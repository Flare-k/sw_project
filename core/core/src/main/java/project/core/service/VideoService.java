package project.core.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.core.dto.ViewRequestDto;
import project.core.model.User;
import project.core.model.Video;
import project.core.repository.UserRepository;
import project.core.repository.VideoRepository;

@Service
public class VideoService {

    private final VideoRepository videoRepository;
    private final UserRepository userRepository;

    public VideoService(VideoRepository videoRepository, UserRepository userRepository) {
        this.videoRepository = videoRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public String save(String username, ViewRequestDto viewRequestDto) {
        User user = userRepository.findByUsername(username).get();
        Long user_id = user.getUserId();

        Video video = Video.builder()
                .videoId(viewRequestDto.getVideoId())
                .fileUrl(viewRequestDto.getFileUrl())
                .thumbnailUrl(viewRequestDto.getThumbnailUrl())
                .title(viewRequestDto.getTitle())
                .description(viewRequestDto.getDescription())
                .platform(viewRequestDto.getPlatform())
                .userId(user_id)
                .build();

        videoRepository.save(video);

        return "Video saved";
    }
}
