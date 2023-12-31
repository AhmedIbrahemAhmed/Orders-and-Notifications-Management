package com.example.demo.Notifications;

public class SendByEmail extends DecoratorCimponent{
    @Override
    public void send() {
        extra();
        super.component.send();
    }
    public void extra(){
        System.out.println("Sending By Email");
    }
}
