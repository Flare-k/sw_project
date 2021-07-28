package project.core.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import project.core.dto.LoginDto;
import project.core.dto.SignupDto;
import project.core.model.Role;
import project.core.model.User;
import project.core.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // 회원가입
    @Transactional
    public User join(SignupDto signupDto) {
        if (userRepository.findOneByUsername(signupDto.getUsername()).orElse(null) != null) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다.");
        }

        Role role = Role.builder()
                .username("ROLE_USER")
                .build();

        User user = User.builder()
                .username(signupDto.getUsername())
                .password(signupDto.getPassword())
                .email(signupDto.getEmail())
                .avatarUrl(signupDto.getAvatarUrl())
                .enabled(true)
                .build();

        user.getRoles().add(role);

        return userRepository.save(user);
    }

    // 로그인
    @Transactional
    public User login(LoginDto loginDto) {
        if (userRepository.findOneByUsername(loginDto.getUsername()).orElse(null) != null) {
            throw new RuntimeException("존재하지 않는 유저입니다.");
        }

        User user = User.builder()
                .username(loginDto.getUsername())
                .password(loginDto.getPassword())
                .build();

        return user;
    }

    // 개인정보
    @Transactional
    public Optional<User> userInfo(Authentication auth) {
        User user = userRepository.findOneByUsername(auth.getName()).orElse(null);
        return userRepository.findOneByUsername(user.getUsername());
    }
}
