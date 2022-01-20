package com.company;

import javax.swing.*;
import java.util.HashMap;
import java.util.Scanner;

class Main {
    static HashMap<String, LinkedList> products = new HashMap<>();

    public static void main(String[] args) {



        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            parseArgument(scanner.nextLine());
        }

    }

    public static void parseArgument(String line){
        String[] keywords = line.split(" ");

        if (keywords.length == 0){
            System.out.println("Something went wrong, please try again");
            return;
        }
        String seller;
        String productName;
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
                if (!products.containsKey(productName)){
                    products.put(productName, new LinkedList());
                }

                    seller = keywords[2];
                price =  Double.parseDouble(keywords[3]);
                products.get(productName).setProductPrice(seller, price);
                break;

            case "SetShippingCost":
                if (keywords.length != 4){
                    System.out.println("Invalid Arguments, please try again");
                    break;
                }
                seller = keywords[1];
                shippingCost = Double.parseDouble(keywords[2]);
                minimumForFreeShipping = Double.parseDouble(keywords[3]);
                // TODO: implement seller
                break;

            case "IncreaseInventory":
                if (keywords.length != 4){
                    System.out.println("Invalid Arguments, please try again");
                    break;
                }
                productName = keywords[1];
                if (!products.containsKey(productName)){
                    System.out.println("Product does not exist");
                    return;
                }

                    seller = keywords[2];
                quantity = Integer.parseInt(keywords[3]);
                products.get(productName).increaseInventory(seller, quantity);
                break;

            case "CustomerPurchase":
                if (keywords.length != 4){
                    System.out.println("Invalid Arguments, please try again");
                    break;
                }
                productName = keywords[1];
                if (!products.containsKey(productName)){
                    System.out.println("Product does not exist");
                    return;
                }
                seller = keywords[2];
                quantity = Integer.parseInt(keywords[3]);
                products.get(productName).customerPurchase(seller, quantity);
                break;

            case "DisplaySellerList":
                if (keywords.length != 2){
                    System.out.println("Invalid Arguments, please try again");
                    break;
                }
                productName = keywords[1];
                if (!products.containsKey(productName)){
                    System.out.println("Product does not exist");
                    return;
                }
                products.get(productName);
                break;

            default:
                System.out.println("Invalid argument, please try again");
                break;
        }
    }




}

