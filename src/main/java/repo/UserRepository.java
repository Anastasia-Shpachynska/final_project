package repo;

import entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository<U extends User> extends BaseRepository<U> {

     Optional<U> findByUsername(String username);
     boolean existsByUsername(String username);
}
