package com.example.demo.Notifications;

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
    @Scheduled(fixedRate = 30000)
    public void send(){
        if(!(messageDB.isEmpty())){
            Message message= messageDB.pop();
            messageHistory.save(message);
            //rest of the sending code
        }

    }
    public  String mostSentNotificationTemplate(){
        return messageHistory.mostSentNotificationTemplate();
    }

}
