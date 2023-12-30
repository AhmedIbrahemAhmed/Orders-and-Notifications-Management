package com.OrdersandNotificationsManager.OrdersandNotificationsManager.Order;

import  com.OrdersandNotificationsManager.OrdersandNotificationsManager.Model.OrderModel.OrderLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Vector;
public class CompoundOrder extends Order {
    protected Vector<SimpleOrder> orders ;

    public CompoundOrder(String ID){
        this.orders = new Vector<>() ;
        this.ID = ID ;
    }
    public CompoundOrder(String ID, Vector<SimpleOrder> orders){
        this.ID = ID ;
        this.orders =orders ;
    }
    public void addOrder(SimpleOrder order){
        orders.add(order) ;
    }
    public void removeOrder(Order order){
        this.orders.remove(order) ;
    }
    public Vector<SimpleOrder> getOrders(){
        return this.orders ;
    }



    @Override
    public String toString() {
        return "CompoundOrder{" +
                "orders=" + orders +
                ", ID='" + ID + '\'' +
                '}';
    }
}
