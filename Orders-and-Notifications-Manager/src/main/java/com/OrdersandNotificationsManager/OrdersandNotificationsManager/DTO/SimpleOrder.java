package com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO;

import com.OrdersandNotificationsManager.OrdersandNotificationsManager.Model.OrderModel.OrderLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

public class SimpleOrder extends Order {
    protected double productPrice ;
    protected double shipmentFees ;
    protected Cart cart = null ;
    protected String shipmentAddress ;
    protected String customerID ;

@Autowired
    public SimpleOrder(String ID, double productPrice, double shipmentFees, Cart cart, String shipmentAddress, String customerID) {
        this.ID = ID;
        this.productPrice = productPrice;
        this.shipmentFees = shipmentFees;
        this.cart = cart;
        this.shipmentAddress = shipmentAddress;
        this.customerID = customerID;
    }



    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getShipmentFees() {
        return shipmentFees;
    }

    public void setShipmentFees(double shipmentFees) {
        this.shipmentFees = shipmentFees;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getShipmentAddress() {
        return shipmentAddress;
    }

    public void setShipmentAddress(String shipmentAddress) {
        this.shipmentAddress = shipmentAddress;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    @Override
    public String toString() {
        return "SimpleOrder{" +
                "ID='" + ID + '\'' +
                ", productPrice=" + productPrice +
                ", shipmentFees=" + shipmentFees +
                ", cart=" + cart +
                ", shipmentAddress='" + shipmentAddress + '\'' +
                ", customerID='" + customerID + '\'' +
                '}';
    }
}
