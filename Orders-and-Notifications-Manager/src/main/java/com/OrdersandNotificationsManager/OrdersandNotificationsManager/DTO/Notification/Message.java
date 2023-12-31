package com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.Notification;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class Message {
    protected String name;
    protected String content;
    private String message;
    protected int ID;
    private  String channel;
    private long customerID;
    protected String template;
    protected String massageLanguage;

    @Autowired
    public Message(Long customerID, int id, Language language, String channel, String name) {
        this.customerID = customerID;
        massageLanguage = language.getLanguage();
        System.out.println(massageLanguage);
        setContent();
        translate(language);
        this.channel=channel;
        this.name = name;
        setMessage();
        this.ID=id;
    }

    public String getTemplate() {
        return template;
    }

    public String getMassageLanguage() {
        return massageLanguage;
    }

    public String getLanguage(Language language) {
        return language.getLanguage();
    }

    public String getContent() {
        return content;
    }

    public String getMessage() {
        return message;
    }

    public int getID() {
        return ID;
    }

    public void setMessage() {
        int count=0;
        String message="";
        for(int i=0; i< content.length(); i++){
            if (content.charAt(i) == '$') {
               if(count==0) {
                   message += name;
               }
               else {
                   message += Integer.toString(ID);
               }
               count++;
            }
            else {
                message += content.charAt(i);
            }
        }
        System.out.println(message);
        this.message=message;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getChannel() {
        return channel;
    }

    public abstract void setContent();

    public Message() {
    }

    public long getCustomerID() {
        return customerID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Message{" +
                "content='" + content + '\'' +
                ", message='" + message + '\'' +
                ", ID=" + ID +
                ", channel='" + channel + '\'' +
                ", customerID=" + customerID +
                '}';
    }

    public void translate(Language language){
        this.content = language.translate(this.content);
    }
}
