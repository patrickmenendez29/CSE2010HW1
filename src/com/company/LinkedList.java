package com.company;

class LinkedList {

    Node head = null;
    Node tail = null;
    String productName;

    public void insert(Node node){

        head = insertRec(head, node);

    }

    private Node insertRec(Node current, Node node){
        if (current == null){
            return node;
        } else {
            current.next = insertRec(current.next, node);
            return current;
        }

    }

    public void remove(Node node){
        removeRec(head, node);
    }

    private void removeRec(Node current, Node node){
        if (current.next == node){
            current.next = null;
            tail = current;

        } else {
            removeRec(current.next, node);
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