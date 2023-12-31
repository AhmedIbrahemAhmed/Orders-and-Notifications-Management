package com.OrdersandNotificationsManager.OrdersandNotificationsManager.Config.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.stereotype.Component;

import javax.security.auth.Subject;

public class UserPrincipalAuthToken extends AbstractAuthenticationToken {
    private final UserPrincipal userPrincipal;

    UserPrincipalAuthToken(UserPrincipal userPrincipal) {
        super(userPrincipal.getAuthorities());
        this.userPrincipal = userPrincipal;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public UserPrincipal getPrincipal() {
        return userPrincipal;
    }
}
