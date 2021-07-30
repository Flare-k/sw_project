package project.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.core.model.RefreshToken;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByKeyr(String key);
}
