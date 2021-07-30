package project.core.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.core.dto.TokenDto;
import project.core.dto.TokenRequestDto;
import project.core.dto.UserRequestDto;
import project.core.dto.UserResponseDto;
import project.core.service.AuthService;

/*
 * 회원가입 (get, post)
 * 로그인 (get, post)
 * 로그인 중인 유저정보 (get)
 * 로그인 중인 유저 정보 편집 (get, post)
 * */

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/join")
    public ResponseEntity<UserResponseDto> join(@RequestBody UserRequestDto userRequestDto) {
        return ResponseEntity.ok(authService.join(userRequestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody UserRequestDto userRequestDto) {
        return ResponseEntity.ok(authService.login(userRequestDto));
    }

    @PostMapping("/reissue")
    public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
        return ResponseEntity.ok(authService.reissue(tokenRequestDto));
    }
}