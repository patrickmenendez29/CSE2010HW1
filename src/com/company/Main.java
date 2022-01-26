package com.company;

import javax.swing.*;
import java.util.HashMap;
import java.util.Scanner;

class Main {


    public static void main(String[] args) {

        LinkedList products = new LinkedList();
        LinkedList sellers = new LinkedList();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            System.out.println("Input: " + line);
            parseArgument(line, products, sellers);
        }

    }



    public static void parseArgument(String line, LinkedList products, LinkedList sellers){
        String[] keywords = line.split(" ");

        if (keywords.length == 0){
            System.out.println("Something went wrong, please try again");
            return;
        }
        String productName;
        Product product;
        String seller;
        double price;
        double shippingCost;
        double minimumForFreeShipping;
        int quantity;


        switch (keywords[0]){

            case "SetProductPrice":
                if (keywords.length != 4){
                    System.out.println("Invalid Arguments, please try again");
                    break;
                }

                productName = keywords[1];
                seller = keywords[2];
                price =  Double.parseDouble(keywords[3]);

                // if the product has not been added yet, add it to the linkedlist

                Seller sellerObj = (Seller) sellers.search(seller);

                if (sellerObj == null){
                    sellerObj = new Seller(seller, price, 0);
                    sellers.insert(sellerObj);
                    System.out.println(sellers);
                } else {
                    sellerObj.setProductPrice(price);
                }
                product = new Product(productName);
                product.setProductPrice(sellerObj, price);

                products.insert(product); // insert the product, no order needed
                System.out.printf("setProductPrice %s %s %s\n", productName, seller, sellerObj.getProductPrice());

                break;

            case "SetShippingCost":
                if (keywords.length != 4){
                    System.out.println("Invalid Argument, please try again");
                    break;
                }
                seller = keywords[1];

                shippingCost = Double.parseDouble(keywords[2]);
                minimumForFreeShipping = Double.parseDouble(keywords[3]);
                Seller sellerObject  = (Seller) sellers.search(seller);
                if (sellerObject == null){
                    return;
                }
                sellerObject.setShippingCost(shippingCost, minimumForFreeShipping);
                break;

            case "IncreaseInventory":

                if (keywords.length != 4){
                    System.out.println("Invalid Argument, please try again");
                    break;
                }
                productName = keywords[1];
                product = (Product) products.search(productName);

                if (product == null){
                    System.out.println("Product does not exist");
                    return;
                }

                seller = keywords[2];
                quantity = Integer.parseInt(keywords[3]);
                product.increaseInventory(seller, quantity);
                break;

            case "CustomerPurchase":
                if (keywords.length != 4){
                    System.out.println("Invalid Argument, please try again");
                    break;
                }
                productName = keywords[1];
                product = (Product) products.search(productName);

                if (product == null){
                    System.out.println("Product does not exist");
                    return;
                }

                seller = keywords[2];
                quantity = Integer.parseInt(keywords[3]);
                product.customerPurchase(seller, quantity);
                break;

            case "DisplaySellerList":
                productName = keywords[1];

                product = (Product) products.search(productName);
                if (keywords.length != 2){
                    System.out.println("Invalid Arguments, please try again");
                    break;
                }

                if (product == null){
                    System.out.println("Product does not exist");
                    return;
                }
                product.displaySellerList();
                break;

            default:
                System.out.println("Invalid argument, please try again");
                break;
        }
    }




}

