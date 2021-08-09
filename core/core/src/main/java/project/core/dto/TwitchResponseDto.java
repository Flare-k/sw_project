package project.core.dto;

import lombok.*;

import java.util.Arrays;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TwitchResponseDto {

    private Datum[] data;

    public Datum[] getData() {
        return data;
    }

    @Getter
    @Data
   public static class Datum {
        public String broadcaster_language;
        public String broadcaster_login;
        public String display_name;
        public String game_id;
        public String game_name;
        public String id;
        public String is_live;
        public String[] tags_ids;
        public String thumbnail_url;
        public String title;
        public String started_at;
    }

    @Override
    public String toString() {
        return "TwitchResponseDto{" +
                "data=" + Arrays.toString(data) +
                '}';
    }


}
