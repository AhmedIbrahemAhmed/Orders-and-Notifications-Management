package com.OrdersandNotificationsManager.OrdersandNotificationsManager.Controller;

import com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.LoginResponse;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.Services.Aunthication.Login;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.Services.Aunthication.Signup;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.Customer;
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

    @PostMapping(path = "/api/signup")
    public Customer register(@RequestBody Customer customer) {
        signup.register(customer);
        return customer;
    }

    @PostMapping(path = "/api/login")
    public String login(@RequestBody LoginResponse loginResponse) {
        return login.login(loginResponse.getEmail(),   loginResponse.getPassword());
    }
}
