package com.OrdersandNotificationsManager.OrdersandNotificationsManager.Model.Massage;

import com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.Notification.Message;

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
