package com.company;

abstract class Node implements Comparable<Node> {

    Node next;
    public String key;

    public Node(String key){
        this.key = key;
    }


    @Override
    public int compareTo(Node o) {
        return 0;
    }
}