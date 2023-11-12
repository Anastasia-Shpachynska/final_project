package repo;

import entity.User;
import org.springframework.stereotype.Repository;
import token.Token;

import java.util.Optional;

@Repository
public interface TokenRepository extends BaseRepository<Token> {

    Optional<Token> findByUser(User user);
    Optional<Token> findByToken(String token);
}