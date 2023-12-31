package com.OrdersandNotificationsManager.OrdersandNotificationsManager.Model.StockModel;

import com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.Product.Product;
import org.springframework.stereotype.Repository;

import java.util.Vector;

@Repository
public class StockDB implements StockRepository {
    protected Vector<Product> items = new Vector<>() ;


    public StockDB() {
        Product product1 = new Product(1,"product1","vendor1","food",15,5) ;
        Product product2 = new Product(2,"product2","vendor1","food",16,4) ;
        Product product3 = new Product(3,"product3","vendor2","games",17,3) ;
        Product product4 = new Product(4,"product4","vendor2","games",18,2) ;
        Product product5 = new Product(5,"product5","vendor3","games",19,1) ;
        items.add(product1) ;
        items.add(product2) ;
        items.add(product3) ;
        items.add(product4) ;
        items.add(product5) ;

    }
    public Product read(int serialNum){
        for(int i=0;i<items.size();i++){
            if(items.elementAt(i).getSeriaolNum() == serialNum){

          return items.elementAt(i);
                 }
            }

        return null;
    }
    public void addProduct(Product product) {
        for (int i = 0; i < items.size(); i++) {
            if (items.elementAt(i) == product) {
                items.elementAt(i).setAmount(items.elementAt(i).getAmount() + product.getAmount());
                return;
            }
        }
        items.add(product) ;
    }
    public void delete(int serialNum){
        for(int i=0;i<items.size();i++){
            if(items.elementAt(i).getSeriaolNum() == serialNum){
                 items.remove(i);
                 return;
                  }
              }
         }
    public void modify(int serialNum,int amount) {
        for (int i = 0; i < items.size(); i++) {
            if (items.elementAt(i).getSeriaolNum() == serialNum) {
                items.elementAt(i).setAmount(amount);
            }
        }
    }
    public Vector<Product> listItems(){
        return items ;
    }

}
