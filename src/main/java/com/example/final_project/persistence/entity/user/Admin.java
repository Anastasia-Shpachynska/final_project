package com.example.final_project.persistence.entity.user;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import com.example.final_project.persistence.type.RoleType;

@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends User{

    public Admin() {
        super();
        setRoleType(RoleType.ADMIN);
    }
}
