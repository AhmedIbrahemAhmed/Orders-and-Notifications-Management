package com.OrdersandNotificationsManager.OrdersandNotificationsManager.Order;

import  com.OrdersandNotificationsManager.OrdersandNotificationsManager.Model.OrderModel.OrderLog;
import org.springframework.stereotype.Service;

@Service
public class CompoundOrderService {
    protected OrderLog orderLog ;

    public CompoundOrderService(OrderLog orderLog) {
        this.orderLog = orderLog;
    }

    public void placeOrder(CompoundOrder order) throws Exception {
        if(orderLog.read(order.getID()) != null)
            throw new Exception("order already exists") ;
        else {
            orderLog.create(order);
            for (Order order1 : order.getOrders())
                orderLog.create(order1);
        }
    }

    public void ship(CompoundOrder order) {
        orderLog.delete(order.getID());
        for(Order order1:order.getOrders())
            orderLog.delete(order1.getID());
    }

    public void cancel(CompoundOrder order) {
        orderLog.delete(order.getID());
        for(Order order1:order.getOrders())
            orderLog.delete(order1.getID());
    }

    public void cancelShipment(CompoundOrder order) {
        orderLog.delete(order.getID());
        for(Order order1:order.getOrders())
            orderLog.delete(order1.getID());
    }
}
