package com.OrdersandNotificationsManager.OrdersandNotificationsManager.Model.CustomerModel;

import com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.Users.Customer;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Vector;

@Component
public class CustomerModel {
    Vector<Customer> customers;

    public CustomerModel() {
        customers = new Vector<>();
    }

    public void create(Customer customer) {
        if (customers.isEmpty() ) {
            customer.setID(0L);
        } else {
            Long lastCustomerID = customers.lastElement().getID();
            customer.setID(lastCustomerID + 1);
        }
        customers.add(customer);
    }

    public void delete(Long ID) {
        for (Customer customer : customers) {
            if (Objects.equals(customer.getID(), ID)){
                customers.remove(customer);
                break;
            }
        }
    }

    public Customer read(Long ID) {
        Customer target = null;
        for (Customer customer : customers) {
            if (Objects.equals(customer.getID(), ID)){
                target = customer;
                break;
            }
        }
        return target;
    }

    public Customer read(String email, String password) {
        Customer target = null;
        for (Customer customer : customers) {
            if (Objects.equals(customer.getPassword(), password)
                    && Objects.equals(customer.getEmail(), email)){
                target = customer;
                break;
            }
        }
        return target;
    }
    public void deduceBalance(String ID,double amount) throws Exception {
        for(int i=0;i<customers.size();i++) {
            if(customers.elementAt(i).getID().toString().equals(ID)) {
                if (customers.elementAt(i).getBalance() < amount) {
                    throw new Exception("no enough balance to pay");
                } else {
                    customers.elementAt(i).setBalance((int) (customers.elementAt(i).getBalance()-amount));
                    return;
                }
            }
        }
    }
}
