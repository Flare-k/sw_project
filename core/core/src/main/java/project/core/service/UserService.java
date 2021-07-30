package project.core.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.core.dto.UserResponseDto;
import project.core.repository.UserRepository;
import project.core.util.SecurityUtil;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public UserResponseDto getMyInfo() {
        return userRepository.findById(SecurityUtil.getCurrentUserId())
                .map(UserResponseDto::of)
                .orElseThrow(() -> new RuntimeException("Does not Exist Login User Info"));
    }

    @Transactional(readOnly = true)
    public UserResponseDto getUserInfo(String username) {
        return userRepository.findByUsername(username)
                .map(UserResponseDto::of)
                .orElseThrow(() -> new RuntimeException("Does not Exist"));
    }
}
