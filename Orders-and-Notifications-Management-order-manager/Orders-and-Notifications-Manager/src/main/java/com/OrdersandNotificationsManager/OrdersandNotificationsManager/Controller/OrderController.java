package com.OrdersandNotificationsManager.OrdersandNotificationsManager.Controller;

import com.OrdersandNotificationsManager.OrdersandNotificationsManager.Config.Security.UserPrincipal;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.CompoundOrder;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.Customer;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.SimpleOrder;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.Model.CustomerModel.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.Services.OrderServices.OrderService ;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.Services.OrderServices.SimpleOrderService ;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.Services.OrderServices.CompoundOrderService ;

@RestController
public class OrderController {
    SimpleOrderService simpleOrder ;
    CompoundOrderService compoundOrder ;
@Autowired
    public OrderController(SimpleOrderService simpleOrder, CompoundOrderService compoundOrder) {
        this.simpleOrder = simpleOrder;
        this.compoundOrder = compoundOrder;
    }

    @PostMapping(path="/placeOrder")
    public Customer placeOrder(@RequestBody SimpleOrder order,
                               @AuthenticationPrincipal UserPrincipal user) throws Exception {
        order.setCustomerID(user.getUserID());
        return simpleOrder.placeOrder(order);
    }
    @DeleteMapping(path="/shipOrder/{ID}")
    public void ship(@PathVariable String ID) {
        compoundOrder.ship(ID);
    }
    @DeleteMapping(path="/cancelOrder/{ID}")
    public  void cancel(@PathVariable String ID) {
        compoundOrder.cancel(ID);
    }
    @DeleteMapping(path="/cancelShipping/{ID}")
    public  void cancelShipment(@PathVariable String ID) {
        compoundOrder.cancelShipment(ID);
    }
    @PostMapping(path="/placeCompoundOrder")
    public  void placeOrder(@RequestBody CompoundOrder order) throws Exception {
        compoundOrder.placeOrder(order);
    }

}
