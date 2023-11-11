package service;

import entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public interface UserService {
    Optional<User> isExist(String email);
    void registerUser(User user);
    UserDetails loadUserByUsername(String email);
}
