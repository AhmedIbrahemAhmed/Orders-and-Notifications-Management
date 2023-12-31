package com.OrdersandNotificationsManager.OrdersandNotificationsManager.Services.OrderServices;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.Order;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.Product;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.SimpleOrder;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.Model.OrderModel.OrderLog;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.Services.Stock.StockManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleOrderService extends OrderService{
    protected OrderLog orderLog ;
    protected StockManagerService stockManagerService ;
@Autowired
    public SimpleOrderService(OrderLog orderLog,StockManagerService stockManagerService) {
        this.orderLog = orderLog;
        this.stockManagerService = stockManagerService ;
    }

    public void placeOrder(SimpleOrder order) throws Exception {
        if(orderLog.read(order.getID())!=null)
            throw new Exception("order already exists") ;
        else {
            orderLog.create(order);
            for(Product product: order.getCart().getProducts()){
                stockManagerService.decrementAmount(product.getSeriaolNum(), product.getAmount());
            }

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
