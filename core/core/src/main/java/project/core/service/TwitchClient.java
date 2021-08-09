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
import java.util.*;


@RequiredArgsConstructor
@Service
public class TwitchClient {

    private  final RestTemplate restTemplate;

    private String twitchClientId = "비밀~";
    private String twitchClientSecret = "비밀~";
    private String twitchAuth = "비밀~";

    private final String channelUrl = "비밀~";
    private final String authUrl = "비밀~";

    public String requestOAuth() {
        String accessToken = "redirect:" + twitchAuth;
        return accessToken;
    }

    public TwitchResponseDto requestVideo(QueryDto queryDto) {

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Client-Id", twitchClientId);
        headers.set("client_secret", twitchClientSecret);
        headers.set("Authorization", twitchAuth);

        final HttpEntity<String> entity = new HttpEntity<>(headers);

        TwitchResponseDto channelData = restTemplate.exchange(channelUrl, HttpMethod.GET, entity, TwitchResponseDto.class, queryDto.getQuery()).getBody();

        Arrays.stream(channelData.getData())
                .forEach(datum -> System.out.println(datum.getId()));

        return restTemplate.exchange(channelUrl, HttpMethod.GET, entity, TwitchResponseDto.class, queryDto.getQuery()).getBody();
    }
}
