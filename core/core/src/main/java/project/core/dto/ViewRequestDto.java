package project.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ViewRequestDto {
    private String videoId;
    private String fileUrl;
    private String thumbnailUrl;
    private String title;
    private String description;
    private String platform;
}
