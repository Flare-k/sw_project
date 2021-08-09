package project.core.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.core.dto.QueryDto;
import project.core.dto.TwitchResponseDto;


@Slf4j
@RequiredArgsConstructor
@Service
public class TwitchService {
    private final TwitchClient twitchClient;

    @Transactional(readOnly = true)
    public String getAuth() {
        return twitchClient.requestOAuth();
    }

    @Transactional(readOnly = true)
    public TwitchResponseDto get(QueryDto queryDto) {
        return twitchClient.requestVideo(queryDto);
    }
}
