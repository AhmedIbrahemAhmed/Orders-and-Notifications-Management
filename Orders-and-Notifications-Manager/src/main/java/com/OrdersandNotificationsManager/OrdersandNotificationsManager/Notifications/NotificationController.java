package com.OrdersandNotificationsManager.OrdersandNotificationsManager.Notifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/Notifications")
public class NotificationController {
    private final NotificationManager notificationManager;
    @Autowired
    public  NotificationController(NotificationManager notificationManager){
        this.notificationManager=notificationManager;
    }
    @GetMapping("/getMessageList")
    public List<Message> showMessagesList(){

        return notificationManager.list();
    }
    @PostMapping("/saveMessage")
    public  void save(@RequestBody Template1 message) throws Exception{
        if(message.getTemplate().equals("Template2")){
            Template2 m=new Template2(message.getCustomerID(),message.getID(),message.getLanguage(),message.getChannel());
            notificationManager.insert(m);
        }
        else notificationManager.insert(message);
    }

    @DeleteMapping (path = "/cancelShip/{ID}")
    public void cancel(@PathVariable("ID") int ID){
        notificationManager.delete(ID);
    }
    @GetMapping("/showMostTemplateUsed")
    public String showMostTemplateUsed(){
        return notificationManager.mostSentNotificationTemplate();
    }
    @GetMapping("/showMostEmail")
    public  String showMostEmailSended(){
        return notificationManager.showMostEmailSended();
    }
    @GetMapping("/showMostPhoneNumber")
    public  String showMostPhoneNumberSended(){
        return  notificationManager.showMostPhoneNumberSended();
    }
}
