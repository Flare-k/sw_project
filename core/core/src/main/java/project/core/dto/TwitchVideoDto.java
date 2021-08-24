package project.core.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TwitchVideoDto {

    private Datum[] data;

    public Datum[] getData() {
        return data;
    }

    @Getter
    @Data
    public static class Datum {
        public String id;
        public String user_name;
        public String title;
        public String description;
        public String created_at;
        public String url;
        public String thumbnail_url;
    }
}
