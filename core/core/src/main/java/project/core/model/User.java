package project.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String username;    // 아이디
    private String password;    // 패스워드
    private String email;       // 이메일
    private String avatarUrl;   // 프로필 사진
    private Boolean enabled;    // 가입했는지 여부

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Builder
    public User(String username, String password, String email, String avatarUrl, Boolean enabled, Authority authority) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.avatarUrl = avatarUrl;
        this.enabled = enabled;
        this.authority = authority;
    }

    // 해당 유저가 본 영상들
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private List<Video> videos = new ArrayList<>();
}
