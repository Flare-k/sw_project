package project.core.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long videoId;
    private String fileUrl;
    private String title;
    private String description;
    private Long views;
    private Date createdAt;

    // video에 달린 comment (video <-> comment)
    @OneToMany(mappedBy = "commentInfo", fetch = FetchType.LAZY)
    private List<Comment> commentInfo = new ArrayList<>();

    // video 업로드한 사람 (video <-> user)
    @ManyToOne
    @JoinColumn(name="videoCreator")  // user의 id
    private User videoCreator;
}
