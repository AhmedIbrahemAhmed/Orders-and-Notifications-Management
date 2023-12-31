package Notifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NotificationManager {
    private final MessageDB messageDB;

    @Autowired
    public NotificationManager(MessageDB messageDB){
    this.messageDB = messageDB;
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
        if(messageDB.isEmpty()){
            Message message= messageDB.pop();
            //rest of the sending code
        }
    }

}
