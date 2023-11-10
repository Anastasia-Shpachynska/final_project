package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user")
public class User {

    private String name;
    @Id
    private String username;
    private String email;
    private String phone;
    private String password;
    private String passwordAgain;
}
