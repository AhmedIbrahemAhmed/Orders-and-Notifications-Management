package com.OrdersandNotificationsManager.OrdersandNotificationsManager.Controller;

import com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.Notification.Message;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.Services.Notfication.NotificationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotificationController {
    private final NotificationManager notificationManager;
    @Autowired
    public  NotificationController(NotificationManager notificationManager){
        this.notificationManager=notificationManager;
    }
    @GetMapping("/notification/getMessageList")
    public List<Message> showMessagesList(){
        return notificationManager.list();
    }
    @GetMapping("/notification/showMostTemplateUsed")
    public String showMostTemplateUsed(){
        System.out.println("show template");
        return notificationManager.mostSentNotificationTemplate();
    }
    @GetMapping("/notification/showMostEmail")
    public  String showMostEmailSended(){
        return notificationManager.showMostEmailSended();
    }
    @GetMapping("/notification/showMostPhoneNumber")
    public  String showMostPhoneNumberSended(){
        return  notificationManager.showMostPhoneNumberSended();
    }
}
