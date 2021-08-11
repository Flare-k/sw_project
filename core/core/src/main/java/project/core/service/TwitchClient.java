package project.core.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import project.core.dto.QueryDto;
import project.core.dto.TwitchResponseDto;
import project.core.dto.TwitchVideoDto;

import java.util.*;


@RequiredArgsConstructor
@Service
public class TwitchClient {

    private  final RestTemplate restTemplate;

    private String twitchClientId = "비밀";
    private String twitchClientSecret = "비밀";
    private String twitchAuth = "Bearer 비밀";

    private final String channelUrl = "https://api.twitch.tv/helix/search/channels?query={keyword}";

    public List<String> requestVideo(QueryDto queryDto) {

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Client-Id", twitchClientId);
        headers.set("client_secret", twitchClientSecret);
        headers.set("Authorization", twitchAuth);

        final HttpEntity<String> entity = new HttpEntity<>(headers);

        TwitchResponseDto channelData = restTemplate.exchange(channelUrl, HttpMethod.GET, entity, TwitchResponseDto.class, queryDto.getQuery()).getBody();

        ArrayList<String> channelList = new ArrayList<>();
        Arrays.stream(channelData.getData())
                .forEach(datum -> channelList.add(datum.getId()));

        ArrayList<String> videoList = new ArrayList<>();
        for (int i = 0; i < channelList.size(); i++) {
            String videoURL = "https://api.twitch.tv/helix/videos?user_id={videoId}";
            String videoId = channelList.get(i);

            TwitchVideoDto videoData = restTemplate.exchange(videoURL, HttpMethod.GET, entity, TwitchVideoDto.class, videoId).getBody();

            Arrays.stream(videoData.getData())
                    .forEach(datum -> videoList.add(datum.getId()));
        }

        // 확인용 출력
//        System.out.println("====Video ID====");
//        for (int i = 0; i < videoList.size(); i++) {
//            System.out.println(videoList.get(i));
//        }


        return videoList;
    }
}
