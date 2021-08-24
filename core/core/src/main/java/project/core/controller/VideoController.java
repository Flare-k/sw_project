package project.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.core.model.User;
import project.core.model.Video;
import project.core.service.UserService;
import project.core.service.VideoService;

/*
* 비디오 업로드 (get, post)
* 비디오 세부정보 (get)
* 비디오 삭제 (delete)
* 비디오 편집 (get, post)
* */
@Controller
@RestController
@RequestMapping("/video")
public class VideoController {

    private final UserService userService;
    private final VideoService videoService;

    public VideoController(UserService userService, VideoService videoService) {
        this.userService = userService;
        this.videoService = videoService;
    }

    // 내가 본 목록 DB에 저장
    @PostMapping("/register/detail/api")
    public Video postViewList(Video video) {
        String curUserName = userService.getMyInfo().getUsername();
        return videoService.save(curUserName, video);
    }
}
