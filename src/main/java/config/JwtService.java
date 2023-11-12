package config;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.function.Function;

public interface JwtService {
    String generateToken(UserDetails userDetails);
    <T> T extractClaims(String token, Function<Claims, T> claimsTFunction);
    boolean isTokenExpired(String token);
    String extractUsername(String token);
}
