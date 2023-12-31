package com.OrdersandNotificationsManager.OrdersandNotificationsManager.Controller;

import com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.CompoundOrder;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.SimpleOrder;
import org.springframework.beans.factory.annotation.Autowired;
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
    public  void placeOrder(@RequestBody SimpleOrder order) throws Exception {
        simpleOrder.placeOrder(order);
    }
    @DeleteMapping(path="/shipOrder/{ID}")
    public  void ship(@PathVariable String ID) {
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
