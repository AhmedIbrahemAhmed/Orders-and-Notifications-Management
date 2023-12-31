package com.example.demo.Notifications;

public abstract class Message {
    protected String content;
    private String message;
    private int ID;
    private  String channel;

    private int customerID;
    protected String template;
    private Language language;

    public String getTemplate() {
        return template;
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
//        int count=0;
//        translate();
//        Customer customer= CustomoerModel.read(this.customerID);
//        String message="";
//        for(int i=0;i<content.length();i++){
//            if (content.charAt(i) == '$') {
//               if(count==0) message+=customer.getName();
//               else message+=Integer.toString(ID);
//                  count++;
//            }
//            else {
//                message+=content.charAt(i);
//            }
//        }
 //       this.message=message;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getChannel() {
        return channel;
    }

    public abstract void setContent();
    public abstract void setTemplate();

    public Message() {
    }

    public Message(int customerID,int id, Language language,String channel) {
        this.customerID = customerID;
        setContent();
        this.language=language;
        this.channel=channel;
        setTemplate();
        setMessage();
        this.ID=id;

    }

    public int getCustomerID() {
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

    public void setLanguage(Language language) {
        this.language = language;
    }

    public void translate(){
        this.content=language.translate(this.content);
    }

}
