package project.core.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.core.dto.UserResponseDto;
import project.core.dto.ViewResponseDto;
import project.core.service.UserService;
import project.core.service.VideoService;

@Controller
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final VideoService videoService;

    public UserController(UserService userService, VideoService videoService) {
        this.userService = userService;
        this.videoService = videoService;
    }

    @GetMapping("/me")
    public ResponseEntity<ViewResponseDto> getMyUserInfo() {
        return ResponseEntity.ok(userService.getMeAndViewInfo());
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserResponseDto> getUserInfo(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUserInfo(username));
    }
}
