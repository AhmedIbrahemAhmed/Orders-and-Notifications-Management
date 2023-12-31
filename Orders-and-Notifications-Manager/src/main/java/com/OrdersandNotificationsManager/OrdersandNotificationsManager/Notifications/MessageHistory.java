package com.OrdersandNotificationsManager.OrdersandNotificationsManager.Notifications;

import com.OrdersandNotificationsManager.OrdersandNotificationsManager.Model.CustomerModel.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Vector;

@Repository
public class MessageHistory implements HistoryRepositry{
    private CustomerModel cutomerModel;

    private final Vector<Message> messages;
    @Autowired
    public MessageHistory(CustomerModel cutomerModel) {
        this.messages = new Vector<>();
        this.cutomerModel = cutomerModel;
    }
    @Override
    public void save(Message message) {
        messages.add(message);
    }

    @Override
    public String mostNotifiedEmail() {
        Map<Long, Integer> customerIdCountMap = new HashMap<>();

        for (Message message : messages) {
            if (message.getChannel().equals("Email")) {
                long customerId = message.getCustomerID();
                customerIdCountMap.put(customerId, customerIdCountMap.getOrDefault(customerId, 0) + 1);
            }
        }

        long mostCustomerId = 0;
        int maxCount = 0;

        for (Map.Entry<Long, Integer> entry : customerIdCountMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostCustomerId = entry.getKey();
            }
        }
        return cutomerModel.read(mostCustomerId).getEmail();
    }

    @Override
    public String mostNotifiedPhoneNumber() {
        Map<Long, Integer> customerIdCountMap = new HashMap<>();

        for (Message message : messages) {
            if (message.getChannel().equals("SMS")) {
                long customerId = message.getCustomerID();
                customerIdCountMap.put(customerId, customerIdCountMap.getOrDefault(customerId, 0) + 1);
            }
        }

        long mostCustomerId = 0;
        int maxCount = 0;

        for (Map.Entry<Long, Integer> entry : customerIdCountMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostCustomerId = entry.getKey();
            }
        }
        return cutomerModel.read(mostCustomerId).getPhoneNumber();
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
