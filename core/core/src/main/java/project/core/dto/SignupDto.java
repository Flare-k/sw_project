package project.core.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignupDto {

    @NotNull
    private String username;

    @NotNull
    @Size(min = 8, max = 12)
    private String password;    // 패스워드

    @NotNull
    private String email;       // 이메일

    private String avatarUrl;   // 프로필 사진

    private Boolean enabled;    // 가입했는지 여부
}
