package project.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    // 내가 본 목록
    @PostMapping("/register/detail/api")
    public void postViewList() {

    }
}
