package data.feedback.repository;

import data.feedback.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmailAndPassword(String email, String password);

    Boolean existsByToken(String token);

    Boolean existsByEmail(String email);
}
