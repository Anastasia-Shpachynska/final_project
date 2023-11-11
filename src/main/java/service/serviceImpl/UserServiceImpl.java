package service.serviceImpl;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import repo.UserRepo;
import service.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo repo;


    @Override
    public void registerUser(User user) {
        PasswordEncoder passwordEncoder =new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        repo.save(user);
    }
    public User loadUserByEmail(String email) throws UsernameNotFoundException {
        User user = repo.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        return user;
    }

    public Optional<User> isExist(String email) {
        return Optional.ofNullable(repo.findByEmail(email));
    }

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = isExist(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));


        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(user.getAuthorities())
                .build();

    }

}
