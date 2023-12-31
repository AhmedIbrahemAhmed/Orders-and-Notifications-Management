package Notifications;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MessageDB implements MessageRepository{
    private final Queue<Message> messages;
    public MessageDB() {
        this.messages = new LinkedList<>();
    }
    @Override
    public boolean isEmpty(){
        return  messages.isEmpty();
    }
    @Override
    public  Message pop(){
        return messages.remove();
    }
    @Override
    public List<Message> findAll() {
        return messages.stream().toList();

    }

    @Override
    public List<Message> findByID(int id) {
        return null;
    }

    @Override
    public void save(Message message) {
        messages.add(message);
    }

    @Override
    public void update(Message message) {
        delete(message.getID());
        save(message);
    }

    @Override
    public void delete(int id) {
        messages.removeIf(currentElement -> currentElement.getID() == id);
    }
}
