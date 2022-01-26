package com.company;

public class Product extends Node {

    class Seller extends Node {

        public Seller(com.company.Seller parent) {
            super(parent.key);

        }

    }
    private final LinkedList sellers; // sorted list of sellers
    private final String productName;

    public Product(String productName) {
        super(productName);
        sellers = new LinkedList();
        this.productName = productName;
    }

    public void setShippingCost(String sellerKey, double shippingCost, double minimumForFreeShipping){
        Seller seller = (Seller) sellers.search(sellerKey);
        if (seller == null){
            return;
        }
        seller.setShippingCost(shippingCost, minimumForFreeShipping);
    }

    public void setProductPrice(Seller seller, double price){
        seller.setProductPrice(price);
        sellers.insertInOrder(seller);
        System.out.println("Product price: " + seller.getProductPrice());


    }


    public void customerPurchase(String sellerKey, int quantity){

        Seller seller = (Seller) sellers.search(sellerKey);
        if (seller == null){
            System.out.println("Seller not found");
            return;
        }
        System.out.println(seller.getInventory());


        if (seller.getInventory() < quantity){
            System.out.println("Not enough inventory, purchase failed");
            return;
        }

        int totalInventory = seller.getInventory() - quantity;
        seller.setInventory(totalInventory);
        System.out.printf("CustomerPurchase %s %s %s %s\n", productName, seller, quantity, seller.getInventory());
    }

    public void displaySellerList(){
        System.out.printf("%s %s %s %s\n", "seller", "productPrice", "shippingCost", "totalCost");
        Seller current = (Seller) sellers.head;
        while (current != null){
            System.out.printf("%s %s %s %s\n", current.getSellerName(), current.getProductPrice(), current.getShippingcost(), current.getTotalCost() );
            current =  (Seller) current.next;
        }
    }

    public void increaseInventory(String sellerKey, int quantity){
        Seller seller = (Seller) sellers.search(sellerKey);
        if (seller == null){
            System.out.println("Seller does not exist");
            return;
        }
        int previousInventory = seller.getInventory();
        int totalInventory = seller.getInventory() + quantity;
        seller.setInventory(totalInventory);
        System.out.printf("IncreaseInventory %s %s %s %s\n", productName, seller.getSellerName(), previousInventory, seller.getInventory());

    }


}
