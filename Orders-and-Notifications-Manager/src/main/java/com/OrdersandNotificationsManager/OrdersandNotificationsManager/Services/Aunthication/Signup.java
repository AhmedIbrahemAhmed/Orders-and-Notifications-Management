package com.OrdersandNotificationsManager.OrdersandNotificationsManager.Services.Aunthication;

import com.OrdersandNotificationsManager.OrdersandNotificationsManager.Model.CustomerModel.CustomerModel;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.Users.Customer;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class Signup {
    CustomerModel customerModel;

    Signup(CustomerModel customerModel) {
        this.customerModel = customerModel;
    }

    public void register(@RequestBody @Validated Customer customer) {

        customerModel.create(customer);
    }
}
