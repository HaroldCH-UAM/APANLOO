package com.example;

public class Node {
    Node left, right;
    char info;

    public Node(char info) {
        this.info = info;
        left = null;
        right = null;
    }
    public Node clone() {
        return new Node(info);
    }
}
