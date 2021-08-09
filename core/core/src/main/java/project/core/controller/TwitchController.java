package project.core.controller;

import org.springframework.web.bind.annotation.*;
import project.core.dto.QueryDto;
import project.core.dto.TwitchResponseDto;
import project.core.service.TwitchService;


@RestController
public class TwitchController {

    private final TwitchService twitchService;

    public TwitchController(TwitchService twitchService) {
        this.twitchService = twitchService;
    }

    @PostMapping("/twitch/api/auth")
    public String accessToken() {
        return twitchService.getAuth();
    }

    @GetMapping("/twitch")
    public TwitchResponseDto getVideos(@RequestBody QueryDto queryDto) {
        return twitchService.get(queryDto);
    }
}
