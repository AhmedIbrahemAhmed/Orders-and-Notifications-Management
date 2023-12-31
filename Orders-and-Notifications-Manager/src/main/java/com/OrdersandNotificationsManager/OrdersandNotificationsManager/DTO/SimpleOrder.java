package com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO;

import org.springframework.beans.factory.annotation.Autowired;

public class SimpleOrder extends Order {
    protected double orderPrice = 0 ;
    protected double shipmentFees ;
    protected Cart cart = null ;
    protected String shipmentAddress ;
    protected Long customerID ;

@Autowired
    public SimpleOrder(String ID, double shipmentFees, Cart cart, String shipmentAddress, Long customerID) {
        this.ID = ID;
        this.shipmentFees = shipmentFees;
        this.cart = cart;
        this.shipmentAddress = shipmentAddress;
        this.customerID = customerID;
        for(Product product: cart.getProducts()){
            this.orderPrice += product.getPrice() ;
        }
    }



    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
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

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    @Override
    public String toString() {
        return "SimpleOrder{" +
                "ID='" + ID + '\'' +
                ", productPrice=" + orderPrice +
                ", shipmentFees=" + shipmentFees +
                ", cart=" + cart +
                ", shipmentAddress='" + shipmentAddress + '\'' +
                ", customerID='" + customerID + '\'' +
                '}';
    }
}
