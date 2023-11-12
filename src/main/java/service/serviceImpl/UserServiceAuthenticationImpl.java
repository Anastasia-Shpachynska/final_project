package service.serviceImpl;

import config.JwtService;
import data.request.RegisterData;
import data.responce.AuthenticationData;
import entity.User;
import exception.EntityNotFoundException;
import exception.UserExistException;
import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import persistence.type.TokenType;
import repo.TokenRepository;
import repo.UserRepository;
import service.UserServiceAuthentication;
import token.Token;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceAuthenticationImpl implements UserServiceAuthentication {

    private  UserRepository userRepository;
    private TokenRepository tokenRepository;
    private PasswordEncoder passwordEncoder;
    private JwtService jwtService;
    private AuthenticationManager authenticationManager;

    @Override
    public AuthenticationData register(RegisterData data) {
        if(userRepository.existsByUsername(data.getEmail())) {
            throw new UserExistException("User already exists");
        }
        User user = new User();
        user.setName(data.getName());
        user.setUsername(data.getEmail());
        user.setPhone(data.getPhone());
        user.setPassword(passwordEncoder.encode(data.getPassword()));
        userRepository.save(user);
        String token = jwtService.generateToken(user);
        saveToken(token, user);
        return new AuthenticationData(token);
    }

    @Override
    public AuthenticationData login(RegisterData data) throws Throwable {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(data.getEmail(), data.getPassword())
        );
        User user = (User) userRepository.findByUsername(data.getEmail())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        Token token = tokenRepository.findByUser(user)
                .orElseThrow(() -> new EntityNotFoundException("Token not found"));
        String accessToken = token.getToken();
        if(jwtService.isTokenExpired(accessToken)) {
            tokenRepository.deleteById(token.getId());
            accessToken = jwtService.generateToken(user);
            saveToken(accessToken, user);
        }
        return new AuthenticationData(accessToken);

    }

    private void saveToken(String accessToken, User user) {
        Token token = new Token();
        token.setToken(accessToken);
        token.setTokenType(TokenType.BEARER);
        token.setUser(user);
        token.setExpired(false);
        token.setRevoked(false);
        tokenRepository.save(token);
    }
}
