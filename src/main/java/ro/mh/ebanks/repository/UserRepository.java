package ro.mh.ebanks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.mh.ebanks.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
