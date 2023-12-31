package com.OrdersandNotificationsManager.OrdersandNotificationsManager.Model.OrderModel;

import com.OrdersandNotificationsManager.OrdersandNotificationsManager.Order.Order;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Vector;
@Component
public class OrderLog {
    private final Vector<Order> orders = new Vector<>();
    public OrderLog(){
    }
    public void create(Order order) throws Exception {
        for(Order order1: orders){
            if(Objects.equals(order1.getID(), order.getID()))
                throw new Exception("order with same ID already exists") ;
        }
        orders.add(order) ;
        System.out.print("created order succesfully with id: ");
        System.out.print(order.getID());
        System.out.println();
    }
    public void delete(String ID){
        for(int i=0;i<orders.size();i++){
            if(Objects.equals(orders.elementAt(i).getID(), ID)) {
                orders.remove(i);
                System.out.println("deletion success");
                break;
            }
        }

    }
    public Order read(String ID){
        for(int i=0;i<orders.size();i++){
            if(Objects.equals(orders.elementAt(i).getID(), ID)) {
                return orders.elementAt(i);
            }
        }
        return null ;
    }
}
