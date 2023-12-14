package com.example.final_project.persistence.entity.user;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import com.example.final_project.persistence.type.RoleType;

@Entity
@DiscriminatorValue("PERSONAL")
public class Personal extends User {

    public Personal() {
        super();
        setRoleType(RoleType.PERSONAL);
    }
}
