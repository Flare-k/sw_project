package project.core.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TwitchVideoDto {

    private TwitchResponseDto.Datum[] data;

    public TwitchResponseDto.Datum[] getData() {
        return data;
    }

    @Getter
    @Data
    public static class Datum {
        public String id;
        public String stream_id;
        public String user_id;
        public String user_login;
        public String user_name;
        public String title;
        public String description;
        public String created_at;
        public String published_at;
        public String url;
        public String thumbnail_url;
        public String viewable;
        public Long view_count;
        public String language;
        public String type;
        public String duration;
        public String[] muted_segments;
    }
}
