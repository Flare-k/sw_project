package project.core.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    private Date createdAt;

    // creator = user
    // (comment <-> user)
    @ManyToOne
    @JoinColumn(name="userId")  // user의 id
    private User commentCreator;

    // (comment <-> video)
    @ManyToOne
    @JoinColumn(name="videoId")  // video의 id
    private Video commentInfo;
}
