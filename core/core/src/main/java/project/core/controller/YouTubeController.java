package project.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import project.core.dto.QueryDto;
import project.core.dto.VideoResponseDto;
import project.core.service.VideoProvider;

import java.util.List;

@RestController
public class YouTubeController {

    private VideoProvider videoProvider;

    @Autowired
    public YouTubeController(final VideoProvider videoProvider) {
        this.videoProvider = videoProvider;
    }

    @GetMapping("/youtube")
    public List<VideoResponseDto> getVideos(@RequestBody QueryDto queryDto) {
        return videoProvider.get(queryDto);
    }
}
