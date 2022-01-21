package com.company;

public class Seller extends Node {

    private String sellerName;
    private double productPrice;
    private int inventory;
    private double minimumForFreeShipping;
    private double shippingcost;

    public Seller(String sellerName, double productPrice, double shippingCost) {
        super(sellerName);
        inventory = 0;

    }

    public void setShippingCost(double shippingCost, double minimumForFreeShipping){
        this.shippingcost = shippingCost;
        this.minimumForFreeShipping = minimumForFreeShipping;

    }

    public void setInventory(int updatedInventory){
        inventory = updatedInventory;
    }


    public void setProductPrice(double productPrice){
        this.productPrice = productPrice;

    }

    public String getSellerName() {
        return sellerName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public int getInventory() {
        return inventory;
    }

    public double getMinimumForFreeShipping() {
        return minimumForFreeShipping;
    }
}
