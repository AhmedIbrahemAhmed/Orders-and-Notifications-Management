package com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO;

public class Customer {
    String userName;
    String password;
    Long ID;
    Integer balance;
    String email;
    String address;

    public Customer(String userName, String password,
                    Long ID, Integer balance,
                    String email, String address) {
        this.userName = userName;
        this.password = password;
        this.ID = ID;
        this.balance = balance;
        this.email = email;
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
