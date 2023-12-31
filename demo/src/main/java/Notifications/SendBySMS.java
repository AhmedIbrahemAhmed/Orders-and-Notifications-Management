package Notifications;

public class SendBySMS extends DecoratorCimponent{
   

    @Override
    public void send() {
        extra();
        super.component.send();
    }
    public void extra(){
        System.out.println("Sending By SMS");
    }
}
