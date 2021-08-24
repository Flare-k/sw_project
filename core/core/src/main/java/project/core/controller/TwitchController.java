package project.core.controller;

import org.springframework.web.bind.annotation.*;
import project.core.dto.QueryDto;
import project.core.dto.TwitchResponseDto;
import project.core.dto.TwitchVideoDto;
import project.core.service.TwitchService;

import java.util.List;


@RestController
public class TwitchController {

    private final TwitchService twitchService;

    public TwitchController(TwitchService twitchService) {
        this.twitchService = twitchService;
    }


/*
# 1.
 * QueryDto를 통해 찾고자하는 채널명을 입력해 채널 API에 던져준다.
 > twitchService로 이동
 */
    @GetMapping("/twitch")
    public List<TwitchVideoDto> getVideos(@RequestBody QueryDto queryDto) {
        return twitchService.get(queryDto);
    }
}
