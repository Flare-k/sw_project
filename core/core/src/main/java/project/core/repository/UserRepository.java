package project.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.core.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
