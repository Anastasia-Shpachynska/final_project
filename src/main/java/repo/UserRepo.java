package repo;

import entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
     User findByEmail(String email);
//     Optional<User> isExistByEmail(String email);
}
