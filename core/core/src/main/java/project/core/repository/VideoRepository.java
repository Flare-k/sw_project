package project.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.core.model.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {
    Boolean findByVideoId(String videoID);
}
