package service;

import data.request.RegisterData;
import data.responce.AuthenticationData;

public interface UserServiceAuthentication {

    AuthenticationData register(RegisterData data);
    AuthenticationData login(RegisterData data) throws Throwable;
}
