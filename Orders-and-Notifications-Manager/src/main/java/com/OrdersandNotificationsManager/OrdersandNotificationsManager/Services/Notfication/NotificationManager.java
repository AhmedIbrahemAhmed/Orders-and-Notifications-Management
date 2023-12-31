package com.OrdersandNotificationsManager.OrdersandNotificationsManager.Services.Notfication;

import com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.Notification.Message;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.Model.Massage.MessageDB;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.Model.Massage.MessageHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NotificationManager {
    private final MessageDB messageDB;
    private final MessageHistory messageHistory;

    @Autowired
    public NotificationManager(MessageDB messageDB,MessageHistory messageHistory){
    this.messageDB = messageDB;
    this.messageHistory=messageHistory;
    }

    public void insert(Message message){
        messageDB.save(message);
    }
    public void delete(int id){

        messageDB.delete(id);
    }

    public List<Message> list(){
      return messageDB.findAll();
    }
    @Scheduled(fixedRate = 300000)
    public void send(){
        if(!messageDB.isEmpty()) {
            Message message = messageDB.pop();
            messageHistory.save(message);
            if (message.getChannel().equalsIgnoreCase("Both")) {
                sendBySMS(message);
                sendByEmail(message);

            }else if (message.getChannel().equalsIgnoreCase("Email")) {
                    sendByEmail(message);
                } else {
                    sendBySMS(message);
                }
            }
        }
    
    public  String mostSentNotificationTemplate(){
        return messageHistory.mostSentNotificationTemplate();
    }
    public  String showMostEmailSended(){
        return messageHistory.mostNotifiedEmail();
    }
    public  String showMostPhoneNumberSended(){
        return messageHistory.mostNotifiedPhoneNumber();
    }
    public void sendBySMS(Message message){
        System.out.println("sent by SMS");
    }
    public  void sendByEmail(Message message){
        System.out.println("sent by Email");
    }

}
