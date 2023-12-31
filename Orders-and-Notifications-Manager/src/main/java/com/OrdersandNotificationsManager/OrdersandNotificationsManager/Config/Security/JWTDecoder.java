package com.OrdersandNotificationsManager.OrdersandNotificationsManager.Config.Security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

// this class responsible for verify and decode JWT token
@Component
public class JWTDecoder {
    private final JWTProperties jwtProperties;

    public JWTDecoder(JWTProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
    }

    public DecodedJWT decode(String token) {
        return JWT.require(Algorithm.HMAC256(jwtProperties.getSecretKey()))
            .build()
            .verify(token);
    }
}
