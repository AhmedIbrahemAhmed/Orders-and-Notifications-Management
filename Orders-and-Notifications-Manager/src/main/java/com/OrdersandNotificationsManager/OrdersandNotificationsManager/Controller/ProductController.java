package com.OrdersandNotificationsManager.OrdersandNotificationsManager.Controller;

import com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.Product;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.SimpleOrder;
import com.OrdersandNotificationsManager.OrdersandNotificationsManager.Services.Stock.StockManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Vector;

@RestController

public class ProductController {
    protected StockManagerService stockManagerService ;
@Autowired
    public ProductController(StockManagerService stockManagerService) {
        this.stockManagerService = stockManagerService;
    }
    @GetMapping(path="/listItems")
    public Vector<Product> listItems() {
        return stockManagerService.listItems();
    }

    @PostMapping(path="/addItem")
    public void addItem(@RequestBody Product product){
        stockManagerService.addProduct(product);
    }
}
