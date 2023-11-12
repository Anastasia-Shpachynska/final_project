package service;

import data.request.RegisterData;
import data.responce.AuthenticationData;
import entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserServiceAuthentication {

    AuthenticationData register(RegisterData data);
    AuthenticationData login(RegisterData data) throws Throwable;
}
