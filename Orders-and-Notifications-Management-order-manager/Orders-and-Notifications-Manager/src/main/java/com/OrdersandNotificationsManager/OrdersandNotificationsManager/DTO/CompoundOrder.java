package com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO;

import com.OrdersandNotificationsManager.OrdersandNotificationsManager.Model.OrderModel.OrderLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Vector;
public class CompoundOrder extends Order {
    protected Vector<SimpleOrder> orders ;

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



    @Override
    public String toString() {
        return "CompoundOrder{" +
                "orders=" + orders +
                ", ID='" + ID + '\'' +
                '}';
    }
}
