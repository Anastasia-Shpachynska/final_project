package service;

import entity.User;

import java.util.Optional;

public interface UserService {
    Optional<User> isExist(String email);
    void registerUser(User user);
}
