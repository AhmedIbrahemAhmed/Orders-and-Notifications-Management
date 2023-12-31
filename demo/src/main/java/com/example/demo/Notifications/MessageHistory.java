package com.example.demo.Notifications;

import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.Vector;

@Repository
public class MessageHistory implements HistoryRepositry{
    private final Vector<Message> messages;
    public MessageHistory() {
        this.messages = new Vector<>();
    }
    @Override
    public void save(Message message) {
        messages.add(message);
    }

    @Override
    public String mostNotifiedEmail() {
        return null;
    }

    @Override
    public String mostNotifiedPhoneNumber() {
        return null;
    }

    @Override
    public String mostSentNotificationTemplate() {
        int template1=0,template2=0;
        for(int i=0;i<messages.size();i++){
            if(messages.elementAt(i) .getTemplate().equals("Template1")){
                template1++;
            }
            else if(messages.elementAt(i) .getTemplate().equals("Template2")) {
                template2++;
            }
        }
        if(template1>=template2){
            return "Template 1";
        }
        else return "Template 2";
    }
}
