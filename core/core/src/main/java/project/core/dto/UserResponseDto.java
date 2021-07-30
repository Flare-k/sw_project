package project.core.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.core.model.User;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {

    private String username;

    public static UserResponseDto of(User user) {
        return new UserResponseDto(user.getUsername());
    }
}
