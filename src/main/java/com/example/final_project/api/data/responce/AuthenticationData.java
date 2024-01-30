package com.example.final_project.api.data.responce;

import com.example.final_project.persistence.type.RoleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationData {

    private String accessToken;
    private RoleType roleType;

}
