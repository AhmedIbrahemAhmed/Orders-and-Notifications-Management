package com.OrdersandNotificationsManager.OrdersandNotificationsManager.Config.Security;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

@Component
public class JWTToPrincipalConvertor {
    public UserPrincipal convert(DecodedJWT jwt) {
        return new UserPrincipal(Long.valueOf(jwt.getSubject()));
    }
}
