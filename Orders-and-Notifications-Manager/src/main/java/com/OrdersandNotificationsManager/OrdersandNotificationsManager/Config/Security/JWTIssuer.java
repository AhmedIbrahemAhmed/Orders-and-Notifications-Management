package com.OrdersandNotificationsManager.OrdersandNotificationsManager.Config.Security;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Component
public class JWTIssuer {
    private final JWTProperties properites;

    public JWTIssuer(JWTProperties properties) {
        this.properites = properties;
    }

    public String issue(Long userID) {
        return JWT.create()
            .withSubject(String.valueOf(userID))
            .withExpiresAt(Instant.now().plus(Duration.of(1, ChronoUnit.DAYS)))
            .sign(Algorithm.HMAC256(properites.getSecretKey()));
    }
}
