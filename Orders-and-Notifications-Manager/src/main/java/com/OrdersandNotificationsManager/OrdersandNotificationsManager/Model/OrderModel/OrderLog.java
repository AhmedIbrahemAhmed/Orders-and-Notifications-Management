package com.OrdersandNotificationsManager.OrdersandNotificationsManager.Model.OrderModel;

import com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.Order.CompoundOrder;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.Order.Order;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.Order.SimpleOrder;
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

    public String list(Long customerID){
        String orderList = "";
        for (Order order : orders) {
            if (order instanceof SimpleOrder) {
                if (Objects.equals(((SimpleOrder) order).getCustomerID(), customerID)) {
                    orderList += (((SimpleOrder) order).toString()) + "\n" + "\n";
                    orderList += "********************************************\n\n";
                }
            }
            else if (order instanceof CompoundOrder) {
                if (Objects.equals(((CompoundOrder) order).getOrders().elementAt(0).getCustomerID(), customerID)) {
                    orderList += (((CompoundOrder) order).toString()) + "\n" + "\n";
                    orderList += "********************************************\n\n";
                }
            }
        }
        return orderList;
    }

}
