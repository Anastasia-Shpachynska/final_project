package config.filter;

import config.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import repo.TokenRepository;
import token.Token;
import util.SecurityUtil;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class AuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final TokenRepository tokenRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(request.getServletPath().contains("/api/open")) {
            filterChain.doFilter(request, response);
            return;
        }
        String authorisation = request.getHeader("Authorisation");
        if(authorisation == null || !authorisation.startsWith("Bearer")) {
            filterChain.doFilter(request, response);
            return;
        }
        String jwt = authorisation.substring(7);
        String username = jwtService.extractUsername(jwt);
        if(username!=null && SecurityUtil.getAuthentication() == null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            Token token = tokenRepository
                    .findByToken(jwt)
                    .orElseThrow(() -> new RuntimeException("Invalid token"));
            if(!jwtService.isTokenExpired(jwt)) {
                var usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                usernamePasswordAuthenticationToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                SecurityUtil.setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
