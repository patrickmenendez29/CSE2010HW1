package com.company;


class LinkedList {

    Node head = null;
    Node tail = null;
    String productName;

    public void insertInOrder(Node node){
        if (head == null){
            head = node;
            return;
        }

        if (head.getTotalCost() > node.getTotalCost()){
            node.next = head;
            head = node;
            return;
        }

            Node current = head;
            Node next = current.next;

            if (next == null){
                current.next = node;
                return;

            }
            while (next.next != null){

                if (next.getTotalCost() > node.getTotalCost()){
                    // change pointers
                    node.next = current.next;
                    current.next = node;
                }
                current = current.next;
                next = next.next;
            }
            next.next = node;


    }

   public void delete(Node node){
        if (head == null){
            return;
        }

        if (head == node){
            head = head.next;
            return;
        }
        Node current = head;

        while (current.next != null){
            if (current.next == node){
                Node next = current.next;
                current.next = next.next;
                return;
            }
        }
   }



    public void pop() {
        Node current = head;
        Node potentialTail = current;
        while (current.next != null){
            potentialTail = current;
            current = current.next;
        }
        tail = potentialTail;
        current = null;

    }

    public void removeHead(){

        head = head.next;

    }

    public void printList(){
        Node current = head;
        while (current != null){
            System.out.println(current.sellerName);
            current = current.next;
        }
    }

    private Node search(String seller){

        if (head == null){
            return null;
        }

        Node current = head;
        while (current != null){

            if (current.sellerName.equals(seller)){
                return current;
            }
            current = current.next;
        }
        return null;

    }

    public void setProductPrice(String seller, double price){
        Node node = search(seller);
        if (node == null){
            System.out.println("Seller not found");
            return;
        }

        node.productPrice = price;
        System.out.printf("setProductPrice %s %s %s\n", productName, seller, price);
    }

    public void setShippingCost(String seller, String shippingCost, String minimumForFreeShipping){
        System.out.printf("SetShippingCost %s %s %s\n", seller, shippingCost, minimumForFreeShipping);
    }

    public void increaseInventory(String seller, int quantity){
        Node node = search(seller);
        if (node == null){
            System.out.println("Seller, not found");
            return;
        }

        node.inventory += quantity;
        System.out.printf("IncreaseInventory %s %s %s %s\n", productName, seller, quantity, node.inventory);
    }

    public void customerPurchase(String seller, int quantity){

        int sellerInventory = 0;
        Node node = search(seller);

        if (sellerInventory <= quantity){
            throw new NotEnoughInventoryError();
        }
        if (node == null){
            System.out.println("Seller not found");
            return;
        }

        node.inventory -= quantity;
        System.out.printf("CustomerPurchase %s %s %s %s\n", productName, seller, quantity, node.inventory);
    }

    public void displaySellerList(){
        System.out.printf("%s %s %s %s", "seller", "productPrice", "shippingCost", "totalCost");
    }




}