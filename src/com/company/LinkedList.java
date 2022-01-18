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

    public void setProductPrice(String seller, String price){

    }

    public void setShippingCost(String seller, String shippingCost, String minimumForFreeShipping){

    }

    public void increaseInventory(String seller, String quantity){

    }

    public void customerPurchase(String seller, String amount){

    }

    public void displaySellerList(){

    }




}