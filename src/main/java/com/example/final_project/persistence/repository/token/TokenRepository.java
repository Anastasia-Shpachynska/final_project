package com.example.final_project.persistence.repository.token;

import com.example.final_project.persistence.entity.token.Token;
import com.example.final_project.persistence.entity.user.User;
import com.example.final_project.persistence.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepository extends BaseRepository<Token> {

    Optional<Token> findByUser(User user);
    Optional<Token> findByToken(String token);
}
