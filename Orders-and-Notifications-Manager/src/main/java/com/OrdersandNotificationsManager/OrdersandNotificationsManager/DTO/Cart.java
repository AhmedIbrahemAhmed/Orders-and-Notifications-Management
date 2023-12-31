package com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO ;

import java.util.Vector;

public class Cart {
    private String ID ;
    private Vector<Product> products ;
    public Cart(){}

    public Cart(String ID) {
        this.ID = ID;
        this.products = new Vector<>() ;
    }

    public String getID() {
        return ID;
    }

    public Vector<Product> getProducts() {
        return products;
    }
    public void addProduct(Product product){
        products.add(product) ;
    }
}
