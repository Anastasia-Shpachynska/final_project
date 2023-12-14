package com.example.final_project.persistence.entity.token;

import com.example.final_project.persistence.entity.BaseEntity;
import com.example.final_project.persistence.entity.user.User;
import com.example.final_project.persistence.type.TokenType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@Table(name = "token")
@AllArgsConstructor
public class Token extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String token;

    @Enumerated(EnumType.STRING)
    @Column(name = "token_type")
    private TokenType tokenType;

    private Boolean expired;
    private Boolean revoked;

    @OneToOne
    private User user;

    public Token() {
        this.tokenType = TokenType.BEARER;
    }
}
