package com.example.demo.Notifications;

public abstract class Component {
    protected Message message;

    public void setMessage(Message message) {
        this.message = message;
    }

    public  abstract  void send();
}
