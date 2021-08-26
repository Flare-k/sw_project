package project.core.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VideoResponseDto {
    private String id;
    private String title;
    private String url;
    private String thumbnails;
    private String platform;

}
