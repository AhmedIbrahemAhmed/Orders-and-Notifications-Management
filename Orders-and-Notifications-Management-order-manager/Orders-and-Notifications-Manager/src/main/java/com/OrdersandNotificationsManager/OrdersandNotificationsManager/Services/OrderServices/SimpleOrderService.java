package com.OrdersandNotificationsManager.OrdersandNotificationsManager.Services.OrderServices;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.Order;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.Product;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.SimpleOrder;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.Model.CustomerModel.CustomerModel;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.Model.OrderModel.OrderLog;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.Services.Stock.StockManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleOrderService extends OrderService{
    protected OrderLog orderLog ;
    protected StockManagerService stockManagerService ;
    protected CustomerModel customerModel;

@Autowired
    public SimpleOrderService(OrderLog orderLog,StockManagerService stockManagerService, CustomerModel customerModel) {
        this.orderLog = orderLog;
        this.stockManagerService = stockManagerService ;
        this.customerModel = customerModel ;
    }

    public void placeOrder(SimpleOrder order) throws Exception {
        if(orderLog.read(order.getID())!=null)
            throw new Exception("order already exists") ;
        else {
            orderLog.create(order);
            for(Product product: order.getCart().getProducts()){
                stockManagerService.decrementAmount(product.getSeriaolNum(), product.getAmount());
            }
            customerModel.deduceBalance(order.getCustomerID().toString(),order.getOrderPrice()+ order.getShipmentFees());

        }
    }

    public void ship(String ID) {
        orderLog.delete(ID);
    }

    public void cancel(String ID) {
        orderLog.delete(ID);
    }

    public void cancelShipment(String ID) {
        orderLog.delete(ID);
    }
}
