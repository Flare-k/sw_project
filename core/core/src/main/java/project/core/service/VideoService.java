package project.core.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.core.model.Video;
import project.core.repository.UserRepository;
import project.core.repository.VideoRepository;

import javax.validation.constraints.Null;

@Service
public class VideoService {

    private final VideoRepository videoRepository;
    private final UserRepository userRepository;

    public VideoService(VideoRepository videoRepository, UserRepository userRepository) {
        this.videoRepository = videoRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public String save(String username, Video video) {
        if (videoRepository.findByVideoId(video.getVideoId())) {
            video.setUser(userRepository.findByUsername(username).get());
            videoRepository.save(video);
        }
        else {
            return "Already Existed Data";
        }
    }
}
