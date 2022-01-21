package com.company;

public class Product extends Node {

    private LinkedList sellers;
    private String productName;

    public Product(String productName) {
        super(productName);
        sellers = new LinkedList();
    }

    public void setShippingCost(String sellerKey, double shippingCost, double minimumForFreeShipping){
        Seller seller = (Seller) sellers.search(sellerKey);
        if (seller == null){
            System.out.println("Error, seller not found");
            return;
        }
        seller.setShippingCost(shippingCost, minimumForFreeShipping);
    }

    public void setProductPrice(String sellerKey, double price){
        Seller seller = (Seller) sellers.search(sellerKey);
        if (seller == null){
            sellers.insertInOrder(new Seller(sellerKey, price, 0));
        } else {
            seller.setProductPrice(price);
        }
        System.out.printf("setProductPrice %s %s %s\n", productName, seller, price);

    }


    public void customerPurchase(String sellerKey, int quantity){

        Seller seller = (Seller) sellers.search(sellerKey);

        if (seller == null){
            System.out.println("Seller not found");
            return;
        }

        if (seller.getInventory() <= quantity){
            throw new NotEnoughInventoryError();
        }

        int totalInventory = seller.getInventory() - quantity;
        seller.setInventory(totalInventory);
        System.out.printf("CustomerPurchase %s %s %s %s\n", productName, seller, quantity, seller.getInventory());
    }

    public void displaySellerList(){
        System.out.printf("%s %s %s %s", "seller", "productPrice", "shippingCost", "totalCost");
    }

    public void increaseInventory(String sellerKey, int quantity){
        Seller seller = (Seller) sellers.search(sellerKey);
        int totalInventory = seller.getInventory() + quantity;
        seller.setInventory(totalInventory);

    }
}
