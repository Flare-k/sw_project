package project.core.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Video {
    @Id
    private String videoId;
    private String fileUrl;
    private String thumbnailUrl;
    private String title;
    private String description;
    private String platform;
    private Long userId;

}