package com.company;

import java.util.Scanner;

class Main {
    static LinkedList products = new LinkedList();

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            parseArgument(scanner.nextLine());
        }

        Node amazon = new Node("Amazon", 10, 10);
        Node apple = new Node("Apple", 10, 10);
        Node microsoft = new Node("Microsoft",  10, 10);
        LinkedList list = new LinkedList();
        list.insert(amazon);
        list.insert(apple);
        list.insert(microsoft);
        list.printList();

    }

    public static void parseArgument(String arg){
        String[] keywords = arg.split(" ");
        if (keywords.length <= 4){

            String command = keywords[0];
            String item = keywords[1];
            String seller = keywords[2];
            String amount = keywords[3];

            executeCommand(command, item, seller, amount);

        } else if (keywords.length == 1){
            products.displaySellerList();
        }
    }

    public static void executeCommand(String command, String ... args){
        String seller;

        switch (command) {
            case "IncreaseInventory" -> {
                String quantity = args[3];
                products.increaseInventory(command, quantity);
            }
            case "CustomerPurchase" -> {
                seller = args[1];
                String amount = args[3];
                products.customerPurchase(seller, amount);
            }
            case "SetShippingCost" -> {
                seller = args[1];
                String shippingCost = args[2];
                String minimumForFreeShipping = args[3];
                products.setShippingCost(seller, shippingCost, minimumForFreeShipping);
            }
            case "SetProductPrice" -> {
                seller = args[1];
                String price = args[3];
                products.setProductPrice(seller, price);
            }
            default -> System.out.println("Parsing error, unknown command");
        }
    }



}

