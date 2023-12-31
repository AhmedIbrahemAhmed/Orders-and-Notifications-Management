package Notifications;

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
        
    }

    @Override
    public String mostNotifiedPhoneNumber() {
        return null;
    }

    @Override
    public String mostSentNotificationTemplate() {
        return null;
    }
}
