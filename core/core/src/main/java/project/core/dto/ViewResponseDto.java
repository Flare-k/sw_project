package project.core.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ViewResponseDto {

    private String fileUrl;
    private String title;
    private String description;
    private Long views;
    private String platform;
}
