package entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Table;

import persistence.type.RoleType;
import java.util.*;



@Getter
@Setter
@Entity
@Table(name="users")
public class User extends BaseEntity implements UserDetails {

    @Column(name = "email", nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String password;

    private String passwordAgain;

    @Column(name = "account_non_expired")
    private Boolean accountNonExpired;

    @Column(name = "account_non_locked")
    private Boolean accountNonLocked;

    @Column(name = "credentials_non_expired")
    private Boolean credentialsNonExpired;

    @Column(name = "enabled")
    private Boolean enabled;

    @Enumerated(EnumType.STRING)
    @Column(name =  "role.type", nullable = false)
    private RoleType roleType;

    public User() {
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roleType.getAuthorities();
    }

    @Override
    public boolean isAccountNonExpired() {

        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {

        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {

        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {

        return this.enabled;
    }
}
