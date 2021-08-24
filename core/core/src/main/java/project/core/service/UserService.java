package project.core.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.core.dto.UserResponseDto;
import project.core.dto.ViewResponseDto;
import project.core.model.Video;
import project.core.repository.UserRepository;
import project.core.repository.VideoRepository;
import project.core.util.SecurityUtil;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final VideoRepository videoRepository;

    @Transactional(readOnly = true)
    public UserResponseDto getMyInfo() {
        return userRepository.findById(SecurityUtil.getCurrentUserId())
                .map(UserResponseDto::of)
                .orElseThrow(() -> new RuntimeException("Does not Exist Login User Info"));
    }

//    @Transactional(readOnly = true)
//    public UserResponseDto getMeAndViewInfo() {
//        UserResponseDto userInfo = userRepository.findById(SecurityUtil.getCurrentUserId())
//                .map(UserResponseDto::of)
//                .orElseThrow(() -> new RuntimeException("Does not Exist Login User Info"));
//
//
//    }

    @Transactional(readOnly = true)
    public UserResponseDto getUserInfo(String username) {
        return userRepository.findByUsername(username)
                .map(UserResponseDto::of)
                .orElseThrow(() -> new RuntimeException("Does not Exist"));
    }
}
