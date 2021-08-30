package project.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.core.model.Video;

import java.util.List;
import java.util.Optional;

public interface VideoRepository extends JpaRepository<Video, Long> {
    Boolean findByVideoId(String videoId);
    List<Video> findByUserId(Long userId);
    Optional<Video> findByVideoIdAndUserId(String videoId, Long userId);
}
