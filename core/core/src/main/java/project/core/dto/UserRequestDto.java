package project.core.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import project.core.model.Authority;
import project.core.model.User;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {

    private String username;
    private String email;
    private String password;
    private String avatarUrl;

    public User toUser(PasswordEncoder passwordEncoder) {
        return User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .email(email)
                .authority(Authority.ROLE_USER)
                .enabled(true)
                .avatarUrl(avatarUrl)
                .build();
    }

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(username, password);
    }
}
