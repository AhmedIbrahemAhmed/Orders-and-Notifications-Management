package com.OrdersandNotificationsManager.OrdersandNotificationsManager.Notifications;

public class Template1 extends Message{
    
    public void setContent(){
       content = " Dear $, Thank you for ordering from our store ";
    }

    public Template1(long customerID,int id, Language language,String channel){

            super( customerID, id, language, channel);
            template="Template1";
        }
//     public void setTemplate(){
//        template="Template1";
//     }
}
