package com.OrdersandNotificationsManager.OrdersandNotificationsManager.Model.StockModel;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.Product;

public interface StockRepository {
     Product read(int serialNum);
     void delete(int serialNum);
     void modify(int serialNum,int amount);
}

