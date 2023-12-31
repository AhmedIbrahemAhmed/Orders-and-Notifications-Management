package com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.Notification;

public class Template2 extends Message {
    public void setContent(){
        content = " Hi $, Great news! Your order with ID $ is Shipped and on its way! ";
    }

    public Template2(long customerID, int id, Language language, String channel, String name){

        super(customerID, id,language,channel, name);
        template="Template2";
    }
}
