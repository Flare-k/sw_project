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
import project.core.dto.VideoResponseDto;
import java.util.*;

@RequiredArgsConstructor
@Service
/*
# 3.
 * twitchService로부터 받은 query를 이용해 API 통신을 주고받는다. 
 */
public class TwitchClient {

    private  final RestTemplate restTemplate;

    private String twitchClientId = "43rhag0wgawd8rl8tsefqptigj3ts7";
    private String twitchClientSecret = "j9432wnffev8p8tndeiokw0ulrpa7k";
    private String twitchAuth = "Bearer 18hp5hdgt7yyt5s47aklcbd827wxq5";

    // 채널을 입력하면 해당하는 데이터를 응답해주는 API
    private final String channelUrl = "https://api.twitch.tv/helix/search/channels?query={keyword}";
    // 채널에서 알아낸 user_id를 기반으로 해당 user가 업로드한 video를 조회하는 API
    private final String videoURL = "https://api.twitch.tv/helix/videos?user_id={userId}";

    public List<VideoResponseDto> requestVideo(QueryDto queryDto) {

        // API에 응답을 보내는 헤더에 client-id, client_secret, Authorization을 실어보내므로써 인증작업을 거친다.
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("client-id", twitchClientId);
        headers.set("client_secret", twitchClientSecret);
        headers.set("Authorization", twitchAuth);

        final HttpEntity<String> entity = new HttpEntity<>(headers);
        //===================================================================================================
        // restTemplate 라이브러리를 이용해 API 통신을 한다 (채널 조회)
        TwitchResponseDto channelData = restTemplate.exchange(channelUrl, HttpMethod.GET, entity, TwitchResponseDto.class, queryDto.getQuery()).getBody();

        // 채널 데이터를 바탕으로 userId를 channelList에 저장한다. (즉, 1차원 배열에 userId를 저장.. 이 아이디를 바탕으로 video를 찾으려고)
        ArrayList<String> channelList = new ArrayList<>();
        Arrays.stream(channelData.getData())
                .forEach(datum -> channelList.add(datum.getId()));

        //===================================================================================================
        // video를 저장할 배열
        ArrayList<VideoResponseDto> videoList = new ArrayList<>();
        
        for (int i = 0; i < 1; i++) {   // 일반적으로 팬계정엔 영상이 없음..
            String userId = channelList.get(i);

            // restTemplate 라이브러리를 이용해 API 통신을 한다 (비디오 조회)
            TwitchVideoDto videoData = restTemplate.exchange(videoURL, HttpMethod.GET, entity, TwitchVideoDto.class, userId).getBody();

            Arrays.stream(videoData.getData())
                    .forEach(datum ->
                        {
                            VideoResponseDto videoResponseDto = new VideoResponseDto();
                            videoResponseDto.setId(datum.getId());
                            videoResponseDto.setTitle(datum.getTitle());
                            videoResponseDto.setUrl(datum.getUrl());
                            String thumbnailUrl = datum.getThumbnail_url().replace("%{width}x%{height}", "400x300");
                            videoResponseDto.setThumbnails(thumbnailUrl);
                            videoResponseDto.setPlatform("twitch");
                            videoList.add(videoResponseDto);
                        });
        }


        return videoList;
    }
}
