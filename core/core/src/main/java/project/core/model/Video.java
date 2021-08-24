package project.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long videoId;
    private String fileUrl;
   // private String thumbnailUrl;
    private String title;
    private String description;
    private Long views;
    private Date createdAt;
    private String platform;

    @ManyToOne
    @JoinColumn(name="user_id")    // name은 Video에 있는 컬럼명
    @JsonIgnore
    private User user;
}
