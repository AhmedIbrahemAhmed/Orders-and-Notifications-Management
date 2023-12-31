package com.OrdersandNotificationsManager.OrdersandNotificationsManager.Services.Aunthication;

import com.OrdersandNotificationsManager.OrdersandNotificationsManager.Config.Security.JWTIssuer;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.Model.CustomerModel.CustomerModel;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.Users.Customer;
import org.springframework.stereotype.Service;

@Service
public class Login {
    JWTIssuer jwtIssuer;
    CustomerModel customerModel;

    Login(CustomerModel customerModel, JWTIssuer jwtIssuer) {
        this.customerModel = customerModel;
        this.jwtIssuer = jwtIssuer;
    }

    public String login(String email, String password) {
        Customer customer = customerModel.read(email, password);
        if (customer == null) {
            return "invalid email or password";
        } else {
            return jwtIssuer.issue(customer.getID());
        }
    }
}
