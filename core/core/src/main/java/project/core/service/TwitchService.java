package project.core.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.core.dto.QueryDto;
import project.core.dto.TwitchResponseDto;
import project.core.dto.TwitchVideoDto;
import project.core.dto.VideoResponseDto;

import java.util.List;


@Slf4j
@RequiredArgsConstructor
@Service
/*
# 2.
 * Controller로부터 받은 query를 twitchClient에 던져준다.
 twitchClient에선 API 통신을 위한 작업을 한다.
 */
public class TwitchService {
    private final TwitchClient twitchClient;

    @Transactional(readOnly = true)
    public List<VideoResponseDto> get(QueryDto queryDto) {
        return twitchClient.requestVideo(queryDto);
    }
}
