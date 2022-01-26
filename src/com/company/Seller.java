package com.company;

import java.util.Comparator;

public class Seller extends Node {


    private final String sellerName;
    private double productPrice;
    private int inventory;
    private double minimumForFreeShipping;
    private double shippingcost;

    public Seller(String sellerName, double productPrice, double shippingCost) {
        super(sellerName);
        inventory = 0;
        this.sellerName = sellerName;
    }

    public void setShippingCost(double shippingCost, double minimumForFreeShipping){
        this.shippingcost = shippingCost;
        this.minimumForFreeShipping = minimumForFreeShipping;
        System.out.printf("SetShippingCost %s %s %s\n", sellerName, shippingCost, minimumForFreeShipping);

    }

    public void setInventory(int updatedInventory){
        inventory = updatedInventory;

    }


    public double getShippingcost() {
        return shippingcost;
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

    public double getTotalCost() {
        return shippingcost + productPrice;
    }
    @Override
    public String toString() {
        return sellerName;
    }

    @Override
    public int compareTo(Node o) {
        Seller seller = (Seller) o;
        return Double.compare(this.getProductPrice(), seller.getProductPrice());
    }
}
