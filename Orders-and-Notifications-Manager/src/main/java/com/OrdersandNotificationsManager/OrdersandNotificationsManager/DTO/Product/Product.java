package com.OrdersandNotificationsManager.OrdersandNotificationsManager.DTO.Product;

public class Product {


    private int seriaolNum ;
    private String name ;
    private String vendor ;
    private String category ;
    private int price ;
    private int amount ;

    public Product(int seriaolNum, String name, String vendor, String category, int price, int amount) {
        this.seriaolNum = seriaolNum;
        this.name = name;
        this.vendor = vendor;
        this.category = category;
        this.price = price;
        this.amount = amount;
    }

    public int getSeriaolNum() {
        return seriaolNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
