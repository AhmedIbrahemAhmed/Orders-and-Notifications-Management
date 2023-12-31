package com.OrdersandNotificationsManager.OrdersandNotificationsManager.Order;

import  com.OrdersandNotificationsManager.OrdersandNotificationsManager.Model.OrderModel.OrderLog;
import org.springframework.stereotype.Service;

@Service
public class CompoundOrderService extends OrderService{
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

    public void ship(String ID) {
        Order order =  orderLog.read(ID);
        orderLog.delete(ID);
        if(order instanceof CompoundOrder order2) {
            for (Order order1 : order2.getOrders())
                orderLog.delete(order1.getID());
        }
    }

    public void cancel(String ID) {
        Order order =  orderLog.read(ID);
        orderLog.delete(ID);

        if(order instanceof CompoundOrder order2) {
            for (Order order1 : order2.getOrders())
                orderLog.delete(order1.getID());
        }
    }

    public void cancelShipment(String ID) {
        Order order =  orderLog.read(ID);
        orderLog.delete(ID);
        if(order instanceof CompoundOrder order2) {
            for (Order order1 : order2.getOrders())
                orderLog.delete(order1.getID());
        }
    }
}
