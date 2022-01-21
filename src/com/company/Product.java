package com.company;

public class Product extends Node {

    private LinkedList sellers; // sorted list of sellers
    private String productName;

    public Product(String productName) {
        super(productName);
        sellers = new LinkedList();
        this.productName = productName;
    }

    public void setShippingCost(Seller seller, double shippingCost, double minimumForFreeShipping){
        if (seller == null){
            System.out.println("Error, seller not found");

        }
        seller.setShippingCost(shippingCost, minimumForFreeShipping);
    }

    public void setProductPrice(String sellerKey, double price){
        Seller seller = (Seller) sellers.search(sellerKey);

        if (seller == null){
            seller = new Seller(sellerKey, price, 0);
            sellers.insert(seller);
        } else {
            seller.setProductPrice(price);
        }

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
        System.out.printf("IncreaseInventory %s %s %s %s\n", productName, seller, quantity, seller.getInventory());

    }


}
