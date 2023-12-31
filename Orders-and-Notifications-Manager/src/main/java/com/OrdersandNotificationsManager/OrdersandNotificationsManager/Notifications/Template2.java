package com.OrdersandNotificationsManager.OrdersandNotificationsManager.Notifications;

public class Template2 extends Message{
    public void setContent(){
        content = " Hi $, Great news! Your order with ID $ is Shipped and on its way! ";
    }

    public Template2(long customerID,int id, Language language,String channel){

        super( customerID, id,language,channel);
        template="Template2";
    }

//     @Override
//     public void setTemplate() {
//         template="Template2";
//     }
}
