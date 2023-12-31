package com.OrdersandNotificationsManager.OrdersandNotificationsManager.Services.OrderServices;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.Customer;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.Order;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.Product;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.SimpleOrder;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.Model.CustomerModel.CustomerModel;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.Model.OrderModel.OrderLog;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.Notifications.Template2;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.Services.Stock.StockManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  com.OrdersandNotificationsManager.OrdersandNotificationsManager.Notifications.NotificationManager;
import  com.OrdersandNotificationsManager.OrdersandNotificationsManager.Notifications.Message;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.Notifications.Language;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.Notifications.English;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.Notifications.Spanish;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.Notifications.Template1;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.Notifications.Template2;

@Service
public class SimpleOrderService extends OrderService{
    protected OrderLog orderLog ;
    protected StockManagerService stockManagerService ;
    protected CustomerModel customerModel;
    protected NotificationManager notificationManager;

@Autowired
    public SimpleOrderService(OrderLog orderLog,StockManagerService stockManagerService, CustomerModel customerModel,NotificationManager notificationManager) {
        this.orderLog = orderLog;
        this.stockManagerService = stockManagerService ;
        this.customerModel = customerModel ;
        this.notificationManager=notificationManager;
    }

    public void placeOrder(SimpleOrder order,String language,String channel) throws Exception {
        if(orderLog.read(order.getID())!=null)
            throw new Exception("order already exists") ;
        else {
            orderLog.create(order);
            Language language1;
            if(language.equalsIgnoreCase("Spanish"))language1=new Spanish();

            else{
                language1=new English();
            }
            Message message=new Template1(order.getCustomerID(),Integer.parseInt(order.getID()),language1,channel);
            notificationManager.insert(message);

        }
            for(Product product: order.getCart().getProducts()){
                stockManagerService.decrementAmount(product.getSeriaolNum(), product.getAmount());

            }
            customerModel.deduceBalance(order.getCustomerID().toString(),order.getOrderPrice() + order.getShipmentFees());
        }

    @Override
    public void ship(String ID, int messageID, String language, String channel) {
        Language language1;
        if (language.equalsIgnoreCase("Spanish")) language1 = new Spanish();

        else {
            language1 = new English();
        }
        SimpleOrder order = (SimpleOrder) orderLog.read(ID);
        Message message = new Template2(order.getCustomerID(), messageID, language1, channel);
        notificationManager.insert(message);


    }
    public void cancel(String ID) {
        orderLog.delete(ID);
    }

    public void cancelShipment(String ID)  {
        notificationManager.delete(Integer.parseInt(ID));
    }
}
