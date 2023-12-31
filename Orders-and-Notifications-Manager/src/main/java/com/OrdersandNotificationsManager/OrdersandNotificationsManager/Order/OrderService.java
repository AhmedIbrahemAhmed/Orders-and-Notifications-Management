package com.OrdersandNotificationsManager.OrdersandNotificationsManager.Order;

public abstract class OrderService {
    public abstract void ship(String ID) ;

    public abstract void cancel(String ID) ;

    public abstract void cancelShipment(String ID) ;
}
