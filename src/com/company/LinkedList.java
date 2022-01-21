package com.company;


class LinkedList {

    Node head = null;
    Node tail = null;

    public void insertInOrder(Node node){
        if (head == null){
            head = node;
            return;
        }

        switch (head.compareTo(node)){
            // head's value is less than
            case -1:
                node.next = head;
                head = node;
                break;
            // head's value is greater or equal to
            case 0:
            case 1:
                Node current = head;
                while (current.next != null && current.next.compareTo(node) < 0){
                    current = current.next;
                    node.next = current.next;
                    current.next = node;
                }
                break;
            // default case ignored to improve readability

        }

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
            System.out.println(current);
            current = current.next;
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






}