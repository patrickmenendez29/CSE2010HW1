package com.company;

public class TestLinkedList {

    TestNode head = null;

    public int size(){
        int res = 0;
        TestNode current = head;

        while (current != null){
            res += 1;
            current = current.next;
        }
        return res;
    }

    @Override
    public String toString() {
        TestNode current = head;

        int currentIndex = 0;
        StringBuilder builder = new StringBuilder();

        while (current != null) {

            builder.append(current.value);
            currentIndex++;
            if (currentIndex < size()){

                builder.append(" < ");
            }
            current = current.next;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        TestNode node = new TestNode(1);
        TestLinkedList linkedList = new TestLinkedList();

    }
}

class TestNode {
    TestNode next;
    int value;

    public TestNode(int value) {
        this.value = value;
    }
}
