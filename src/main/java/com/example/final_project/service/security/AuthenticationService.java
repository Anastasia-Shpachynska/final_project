package com.example.final_project.service.security;

import com.example.final_project.api.data.request.RegisterData;
import com.example.final_project.api.data.responce.AuthenticationData;

public interface AuthenticationService {

    AuthenticationData register(RegisterData data);
    AuthenticationData login(RegisterData data);
}
