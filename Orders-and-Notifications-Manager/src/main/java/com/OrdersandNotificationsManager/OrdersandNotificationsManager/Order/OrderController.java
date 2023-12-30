package com.OrdersandNotificationsManager.OrdersandNotificationsManager.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    @DeleteMapping(path="/shipOrder")
    public  void ship(@RequestBody SimpleOrder order) {
        simpleOrder.ship(order);
    }
    @DeleteMapping(path="/cancelOrder")
    public  void cancel(@RequestBody SimpleOrder order) {
        simpleOrder.cancel(order);
    }
    @DeleteMapping(path="/cancelShipping")
    public  void cancelShipment(@RequestBody SimpleOrder order) {
        simpleOrder.cancelShipment(order);
    }
    @PostMapping(path="/placeCompoundOrder")
    public  void placeOrder(@RequestBody CompoundOrder order) throws Exception {
        compoundOrder.placeOrder(order);
    }
    @DeleteMapping(path="/shipCompoundOrder")
    public  void ship(@RequestBody CompoundOrder order) {
        compoundOrder.ship(order);
    }
    @DeleteMapping(path="/cancelCompoundOrder")
    public  void cancel(@RequestBody CompoundOrder order) {
        compoundOrder.cancel(order);
    }
    @DeleteMapping(path="/cancelCompoundShipping")
    public  void cancelShipment(@RequestBody CompoundOrder order) {
        compoundOrder.cancelShipment(order);
    }
}
