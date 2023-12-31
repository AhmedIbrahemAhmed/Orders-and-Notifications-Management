package com.OrdersandNotificationsManager.OrdersandNotificationsManager.Order;

import  com.OrdersandNotificationsManager.OrdersandNotificationsManager.Model.OrderModel.OrderLog;
import org.springframework.stereotype.Service;

@Service
public class SimpleOrderService extends OrderService{
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

    public void ship(String ID) {
        orderLog.delete(ID);
    }

    public void cancel(String ID) {
        orderLog.delete(ID);
    }

    public void cancelShipment(String ID) {
        orderLog.delete(ID);
    }
}
