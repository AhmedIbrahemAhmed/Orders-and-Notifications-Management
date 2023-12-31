package com.OrdersandNotificationsManager.OrdersandNotificationsManager.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
