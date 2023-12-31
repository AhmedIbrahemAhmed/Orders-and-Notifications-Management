package com.example.demo.Notifications;

public abstract class DecoratorCimponent extends Component{
    protected  Component component;


    public void setComponent(Component component) {
        this.component = component;
    }
    
}
