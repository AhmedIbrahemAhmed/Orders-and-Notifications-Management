package com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.Order;

import com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.Order.Order;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.Order.SimpleOrder;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import java.util.Vector;
public class CompoundOrder extends Order {
    private Vector<SimpleOrder> orders ;

    public CompoundOrder(String ID){
        this.orders = new Vector<>() ;
        this.ID = ID ;
    }
    public CompoundOrder(String ID, Vector<SimpleOrder> orders, double shippingFees){
        this.ID = ID ;
        this.orders =orders ;
        for(int i=0;i< orders.size();i++){
            orders.elementAt(i).setShipmentFees(shippingFees/orders.size());
        }
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

    public void setOrders(Vector<SimpleOrder> orders) {
        this.orders.addAll(orders);
    }

    @Override
    public String toString() {
        return "CompoundOrder{" +
                "orders=" + orders +
                ", ID='" + ID + '\'' +
                '}';
    }
}
