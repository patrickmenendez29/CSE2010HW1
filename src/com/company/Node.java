package com.company;

class Node {
    Node next;

    String sellerName;
    double productPrice;
    double shippingcost;

    public Node(String sellerName, double productPrice, double shippingCost){

        this.sellerName = sellerName;
        this.productPrice = productPrice;
        this.shippingcost = shippingCost;

    }

    public double getTotalCost() {
        return productPrice + shippingcost;
    }

}