package project.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.core.dto.QueryDto;
import project.core.dto.VideoResponseDto;
import project.core.dto.ViewRequestDto;
import project.core.service.TwitchService;
import project.core.service.UserService;
import project.core.service.VideoProvider;
import project.core.service.VideoService;

import java.util.ArrayList;
import java.util.List;


@Controller
@RestController
@RequestMapping("/video")
public class VideoController {

    private final UserService userService;
    private final VideoService videoService;
    private final VideoProvider videoProvider;  // youtube
    private final TwitchService twitchService;  // twitch

    public VideoController(UserService userService, VideoService videoService, VideoProvider videoProvider, TwitchService twitchService) {
        this.userService = userService;
        this.videoService = videoService;
        this.videoProvider = videoProvider;
        this.twitchService = twitchService;
    }

    @GetMapping("/search")
    public List<VideoResponseDto> getVideos(@RequestBody QueryDto queryDto) {
        List<VideoResponseDto> videoList = new ArrayList<>();
        videoList.addAll(videoProvider.get(queryDto));
        videoList.addAll(twitchService.get(queryDto));
        return videoList;
    }

    // 내가 본 목록 DB에 저장
    @PostMapping("/register/detail/api")
    public String postViewList(@RequestBody ViewRequestDto viewRequestDto) {
        String curUserName = userService.getMyInfo().getUsername();
        return videoService.save(curUserName, viewRequestDto);
    }
}
