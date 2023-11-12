package entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
import javax.persistence.Index;
import jakarta.persistence.Table;
import javax.validation.constraints.NotNull;

import persistence.type.RoleType;
//import java.util.Collection;
import java.util.*;



@Getter
@Setter
@Entity
@Table(name="user")
public class User extends BaseEntity implements UserDetails {

    @Column(nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String password;

    private String passwordAgain;

    @Enumerated(EnumType.STRING)
    @Column(name =  "role.type", nullable = false)
    private RoleType roleType;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roleType.getAuthorities();
    }

    @Override
    public boolean isAccountNonExpired() {

        return this.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {

        return this.isEnabled();
    }

}
