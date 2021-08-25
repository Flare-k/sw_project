package project.core.dto;

import lombok.*;

import java.util.Arrays;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
/*
# 1.
 * 채널 API의 응답 데이터를 아래의 DTO로 실어서 가져온다.
 */
public class TwitchResponseDto {

    private Datum[] data;

    public Datum[] getData() {
        return data;
    }

    @Getter
    @Data
    public static class Datum {
        public String id;
        public String thumbnail_url;
        public String title;
    }
}
