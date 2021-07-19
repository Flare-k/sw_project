package project.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.core.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
