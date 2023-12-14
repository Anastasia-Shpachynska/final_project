package com.example.final_project.persistence.repository.user;

import com.example.final_project.persistence.entity.user.Personal;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalRepository extends UserRepository<Personal> {
}
