package com.OrdersandNotificationsManager.OrdersandNotificationsManager.Services.Stock;


import com.OrdersandNotificationsManager.OrdersandNotificationsManager.Model.StockModel.StockDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.*;

import java.util.Vector;

@Service
public class StockManagerService {
    private final StockDB stock;
    @Autowired
    public StockManagerService(StockDB stock){
        this.stock =stock;
    }
    public void addAmount(int serialNumber,int amount) throws Exception {
        Product product = stock.read(serialNumber) ;
        if(product== null){
            throw new Exception("couldn't find this product") ;
        }
        else{
            stock.modify(serialNumber,amount + product.getAmount());
        }
    }
    public void decrementAmount(int serialNumber,int amount) throws Exception {
        Product product = stock.read(serialNumber) ;
        if(product== null){
            throw new Exception("couldn't find this product") ;
        }
        else{
            if(product.getAmount()< amount){
                throw new Exception("not enough products to deduce") ;
            }
            else
                stock.modify(serialNumber,amount + product.getAmount());
        }
    }
    public void addProduct(Product product){
        stock.addProduct(product);
    }
    public Vector<Product> listItems(){
        return stock.listItems() ;
    }
}

