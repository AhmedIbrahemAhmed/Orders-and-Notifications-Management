package com.example.demo.Notifications;

public class Template2 extends Message{
    public void setContent(){
        content = " Hi $, Great news! Your order with ID $ is in its way! ";
    }

    @Override
    public void setTemplate() {
        template="Template2";
    }
}
