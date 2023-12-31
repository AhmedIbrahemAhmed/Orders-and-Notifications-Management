package com.OrdersandNotificationsManager.OrdersandNotificationsManager.Controller;

import com.OrdersandNotificationsManager.OrdersandNotificationsManager.Config.Security.UserPrincipal;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.Order.CompoundOrder;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.Order.SimpleOrder;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.Users.Customer;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.Model.OrderModel.OrderLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.Services.OrderServices.SimpleOrderService ;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.Services.OrderServices.CompoundOrderService ;

@RestController
public class OrderController {
    SimpleOrderService simpleOrder;
    CompoundOrderService compoundOrder;

    @Autowired
    public OrderController(SimpleOrderService simpleOrder, CompoundOrderService compoundOrder) {
        this.simpleOrder = simpleOrder;
        this.compoundOrder = compoundOrder;
    }

    @PostMapping(path = "/placeOrder/{language}/{channel}")
    public String placeOrder(@RequestBody SimpleOrder order, @PathVariable String language, @PathVariable String channel,
                               @AuthenticationPrincipal UserPrincipal user) throws Exception {
        order.setCustomerID(user.getUserID());
        return simpleOrder.placeOrder(order,language,channel);
    }

    @PostMapping(path = "/shipOrder/{ID}/{messageID}/{language}/{channel}")
    public String ship(@PathVariable String ID, @PathVariable int messageID, @PathVariable String language ,@PathVariable  String channel) {
        compoundOrder.ship(ID,messageID,language,channel);
        return "Order with ID: " + ID + " has been shipped";
    }

    @DeleteMapping(path = "/cancelOrder/{ID}")
    public String cancel(@PathVariable String ID) {
        compoundOrder.cancel(ID);
        return "Order with ID: " + ID + " has been canceled ";
    }

    @DeleteMapping(path = "/cancelShipping/{ID}")
    public String cancelShipment(@PathVariable String ID) {
        compoundOrder.cancelShipment(ID);
        return "Order with ID: " + ID + " shipment has been canceled";
    }

    @PostMapping(path = "/placeCompoundOrder/{language}/{channel}")
    public String placeOrder(@RequestBody CompoundOrder order,@PathVariable String language,@PathVariable String channel) throws Exception {
        compoundOrder.placeOrder(order, language, channel);
        return "the Compound order with ID: " + order.getID() + " has been placed";
    }

    @GetMapping(path = "/listOrder")
    public String listOrders(@AuthenticationPrincipal UserPrincipal user) {
        return simpleOrder.listOrders(user.getUserID());
    }
}
