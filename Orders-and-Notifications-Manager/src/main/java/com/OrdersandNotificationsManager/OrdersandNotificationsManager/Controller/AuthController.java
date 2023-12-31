package com.OrdersandNotificationsManager.OrdersandNotificationsManager.Controller;

import com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.Authuntication.LoginResponse;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.Services.Aunthication.Login;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.Services.Aunthication.Signup;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.Users.Customer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    Signup signup;
    Login login;

    AuthController(Signup signup, Login login) {
        this.signup = signup;
        this.login = login;
    }

    @PostMapping(path = "/auth/signup")
    public Customer register(@RequestBody Customer customer) {
        signup.register(customer);
        return customer;
    }

    @PostMapping(path = "/auth/login")
    public String login(@RequestBody LoginResponse loginResponse) {
        return login.login(loginResponse.getEmail(),   loginResponse.getPassword());
    }
}
