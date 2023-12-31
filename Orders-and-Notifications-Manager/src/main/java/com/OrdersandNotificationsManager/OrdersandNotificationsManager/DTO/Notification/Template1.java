package com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.Notification;

public class Template1 extends Message {
    public void setContent(){
       content = " Dear $, Thank you for ordering from our store ";
    }

    public Template1(long customerID, int id, Language language, String channel, String name) {
        super(customerID, id, language, channel, name);
        template = "Template1";
    }
}
