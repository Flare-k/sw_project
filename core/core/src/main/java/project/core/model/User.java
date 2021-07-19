package project.core.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;
    private String password;
    private String email;
    private String avatarUrl;   // 프로필 사진

    // (user <-> comment)
    @OneToMany(mappedBy = "commentCreator", fetch = FetchType.LAZY)
    private List<Comment> commentCreator = new ArrayList<>();

    // (user <-> video)
    @OneToMany(mappedBy = "videoCreator", fetch = FetchType.LAZY)
    private List<Video> videoCreator = new ArrayList<>();


}
