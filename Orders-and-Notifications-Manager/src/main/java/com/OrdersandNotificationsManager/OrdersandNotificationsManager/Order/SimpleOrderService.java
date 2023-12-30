package com.OrdersandNotificationsManager.OrdersandNotificationsManager.Order;

import  com.OrdersandNotificationsManager.OrdersandNotificationsManager.Model.OrderModel.OrderLog;
import org.springframework.stereotype.Service;

@Service
public class SimpleOrderService {
    protected OrderLog orderLog ;

    public SimpleOrderService(OrderLog orderLog) {
        this.orderLog = orderLog;
    }

    public void placeOrder(Order order) throws Exception {
        if(orderLog.read(order.getID())!=null)
            throw new Exception("order already exists") ;
        else {
            orderLog.create(order);
        }
    }

    public void ship(Order order) {
        orderLog.delete(order.getID());
    }

    public void cancel(Order order) {
        orderLog.delete(order.getID());
    }

    public void cancelShipment(Order order) {
        orderLog.delete(order.getID());
    }
}
