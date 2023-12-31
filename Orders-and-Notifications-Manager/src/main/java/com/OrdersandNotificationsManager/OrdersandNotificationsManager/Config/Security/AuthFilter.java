package com.OrdersandNotificationsManager.OrdersandNotificationsManager.Config.Security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
public class AuthFilter extends OncePerRequestFilter {
    private final JWTDecoder jwtDecoder;
    private final JWTToPrincipalConvertor jwtToPrincipalConvertor;

    public AuthFilter(JWTDecoder jwtDecoder, JWTToPrincipalConvertor jwtToPrincipalConvertor) {
        this.jwtDecoder = jwtDecoder;
        this.jwtToPrincipalConvertor = jwtToPrincipalConvertor;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        extractToken(request)
            .map(jwtDecoder::decode)
            .map(jwtToPrincipalConvertor::convert)
            .map(UserPrincipalAuthToken::new)
            .ifPresent(auth -> SecurityContextHolder.getContext().setAuthentication(auth));
        filterChain.doFilter(request, response);

    }

    private Optional<String> extractToken(HttpServletRequest request) {
        var token = request.getHeader("Authorization");
        if (StringUtils.hasText(token) && token.startsWith("Bearer")) {
            String actualTokenWithOutBearer = token.substring(7);
            return Optional.of(actualTokenWithOutBearer);
        }
        return Optional.empty();
    }
}
