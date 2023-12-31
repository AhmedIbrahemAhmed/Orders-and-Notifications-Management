package com.OrdersandNotificationsManager.OrdersandNotificationsManager.Services.OrderServices;

public abstract class OrderService {
    public abstract void ship(String ID,int messageID,String language,String channel) ;

    public abstract void cancel(String ID) ;

    public abstract void cancelShipment(String ID) ;
}
