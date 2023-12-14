package com.example.final_project.persistence.repository.user;

import com.example.final_project.persistence.entity.user.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends UserRepository<Admin> {
}
