package token;

import entity.BaseEntity;
import entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import persistence.type.TokenType;

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
