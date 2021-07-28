package project.core.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import project.core.dto.LoginDto;
import project.core.dto.SignupDto;
import project.core.model.User;
import project.core.service.UserService;

import javax.validation.Valid;

/*
* 회원가입 (get, post)
* 로그인 (get, post)
* 로그인 중인 유저정보 (get)
* 로그인 중인 유저 정보 편집 (get, post)
* */
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 회원가입
    @GetMapping("/join")
    public void getJoin() {
        // 회원가입 페이지
    }

    @PostMapping("/join/api")
    public ResponseEntity<User> postJoin(@Valid @RequestBody SignupDto signupDto) {
        return ResponseEntity.ok(userService.join(signupDto));
    }

    // 로그인
    @GetMapping("/login")
    public void getLogin() {
        // 로그인 페이지
    }

    @PostMapping("/login/api")
    public ResponseEntity<User> postLogin(@Valid @RequestBody LoginDto loginDto) {
        return ResponseEntity.ok(userService.login(loginDto));
    }
    
    // 개인정보
    @GetMapping("/info")
    public ResponseEntity<User> getUserInfo(String username) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok(userService.userInfo(auth).get());
    }
}
