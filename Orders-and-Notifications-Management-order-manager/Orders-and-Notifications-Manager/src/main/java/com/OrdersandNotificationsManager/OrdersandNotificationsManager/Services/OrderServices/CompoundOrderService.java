package com.OrdersandNotificationsManager.OrdersandNotificationsManager.Services.OrderServices;

import com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.CompoundOrder;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.SimpleOrder;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.Model.OrderModel.OrderLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.Order;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.Services.OrderServices.SimpleOrderService ;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.Services.OrderServices.OrderService ;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.Services.OrderServices.CompoundOrderService ;

@Service
public class CompoundOrderService extends OrderService{
    protected final OrderLog orderLog ;
    private final SimpleOrderService simpleorder;

@Autowired
    public CompoundOrderService(OrderLog orderLog, SimpleOrderService simpleorder) {
        this.orderLog = orderLog;
        this.simpleorder=simpleorder;
    }

    public void placeOrder(CompoundOrder order) throws Exception {
        if(orderLog.read(order.getID()) != null)
            throw new Exception("order already exists") ;
        else {
            orderLog.create(order);
            for (SimpleOrder order1 : order.getOrders())
                simpleorder.placeOrder(order1);
        }
    }

    public void ship(String ID) {
        Order order =  orderLog.read(ID);
        orderLog.delete(ID);
        if(order instanceof CompoundOrder order2) {
            for (Order order1 : order2.getOrders())
                simpleorder.ship(order1.getID());
        }
    }

    public void cancel(String ID) {
        Order order =  orderLog.read(ID);
        orderLog.delete(ID);

        if(order instanceof CompoundOrder order2) {
            for (Order order1 : order2.getOrders())
               simpleorder.cancel(order1.getID());
        }
    }

    public void cancelShipment(String ID) {
        Order order =  orderLog.read(ID);
        orderLog.delete(ID);
        if(order instanceof CompoundOrder order2) {
            for (Order order1 : order2.getOrders())
                simpleorder.cancelShipment(order1.getID());
        }
    }
}
