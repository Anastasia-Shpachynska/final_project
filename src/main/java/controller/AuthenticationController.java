package controller;

import data.request.RegisterData;
import data.responce.AuthenticationData;
import data.responce.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.UserServiceAuthentication;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/open/auth")
public class AuthenticationController {

    private UserServiceAuthentication userServiceAuthentication;
    @PostMapping("/register")
    public ResponseEntity<ResponseData<AuthenticationData>> register(@RequestBody RegisterData data) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseData<>(userServiceAuthentication.register(data)));
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseData<AuthenticationData>> login(@RequestBody RegisterData data) throws Throwable {
        return ResponseEntity.ok(new ResponseData<>(userServiceAuthentication.login(data)));
    }
}
