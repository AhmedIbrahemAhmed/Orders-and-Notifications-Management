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

    @PostMapping(path="/placeOrder/{language}/{channel}")
    public void placeOrder(@RequestBody SimpleOrder order,@PathVariable String language,@PathVariable String channel,
                               @AuthenticationPrincipal UserPrincipal user) throws Exception {
        order.setCustomerID(user.getUserID());
        simpleOrder.placeOrder(order,language,channel);
    }

    @DeleteMapping(path="/shipOrder/{ID}/{messageID}/{language}/{channel}")
    public void ship(@PathVariable String ID, @PathVariable int messageID, @PathVariable String language ,@PathVariable  String channel) {
        compoundOrder.ship(ID,messageID,language,channel);
    }

    @DeleteMapping(path="/cancelOrder/{ID}")
    public  void cancel(@PathVariable String ID) {
        compoundOrder.cancel(ID);
    }

    @DeleteMapping(path="/cancelShipping/{ID}")
    public  void cancelShipment(@PathVariable String ID) {
        compoundOrder.cancelShipment(ID);
    }

    @PostMapping(path="/placeCompoundOrder/{language}/{channel}")
    public  void placeOrder(@RequestBody CompoundOrder order,@PathVariable String language,@PathVariable String channel) throws Exception {
        compoundOrder.placeOrder(order, language, channel);
    }

}
