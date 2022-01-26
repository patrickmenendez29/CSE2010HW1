package com.company;


class LinkedList {

    Node head = null;
    Node tail = null;

    public void insertInOrder(Node node){

        // base case
        if (head == null){
            head = node;
            return;
        }
        if (head.compareTo(node) > 0){
            node.next = head;
            head = node;
            return;
        }
        Node current = head;
        while (current.next != null){

            if (current.next.compareTo(node) > 0){
                node.next = current.next;
                current.next = node;
                return;
            }
            current = current.next;

        }
        current.next = node;

    }

    // insert element without order (no need to use compareTo)
    public void insert(Node node){
        if (head == null){
            head = node;
            return;
        }
        Node current = head;

        while (current.next != null){
            current = current.next;
        }
        current.next = node;

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
         if (head instanceof Product) {
             ((Product) head).displaySellerList();
        } else {
             System.out.println("Invalid type of linkedlist for this command");
         }
    }

    public Node search(String key){

        if (head == null){
            return null;
        }

        Node current = head;
        while (current != null){

            if (current.key.equals(key)){
                return current;
            }
            current = current.next;
        }
        return null;

    }


public int size(){
        Node current = head;
        int res = 0;
        while (current != null){
            res++;
            current = current.next;
        }
        return res;
}

    @Override
    public String toString() {
        Node current = head;
        int currentIndex = 0;
        StringBuilder builder = new StringBuilder();

        while (current != null) {

            builder.append(current.key);
            currentIndex++;
            if (currentIndex < size()){

                builder.append(" < ");
            }
            current = current.next;
        }
        return builder.toString();
    }
}