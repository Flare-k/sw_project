package project.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.core.model.Video;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Long> {
    Boolean findByVideoId(String videoId);
    List<Video> findByUserId(Long userId);
    Boolean findByVideoIdAndUserId(String videoId, Long userId);
}
