package project.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.core.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);    // 아이디로 조회
    Boolean existsByUsername(String username);  // 중복 가입 방지
}
