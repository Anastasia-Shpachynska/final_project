package com.example.final_project.api.controller.open;

import com.example.final_project.api.data.request.RegisterData;
import com.example.final_project.api.data.responce.AuthenticationData;
import com.example.final_project.api.data.responce.ResponseData;
import com.example.final_project.service.security.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/open/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<ResponseData<AuthenticationData>> register(@RequestBody RegisterData data) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseData<>(authenticationService.register(data)));
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseData<AuthenticationData>> login(@RequestBody RegisterData data) {
        return ResponseEntity.ok(new ResponseData<>(authenticationService.login(data)));
    }
}
