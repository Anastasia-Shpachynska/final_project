package com.example.final_project.persistence.repository.user;

import com.example.final_project.persistence.entity.user.User;
import com.example.final_project.persistence.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository<U extends User> extends BaseRepository<U> {

    Optional<U> findByUsername(String username);
    boolean existsByUsername(String username);
}
