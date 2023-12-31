package com.example.demo.Notifications;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface MessageRepository {
    public List<Message> findAll();
    public List<Message> findByID(int id);
    public void save(Message message);
    public void update(Message message);
    public void delete(int id);
    public boolean isEmpty();
    public  Message pop();

}
