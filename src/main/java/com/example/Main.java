package com.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Tree arbol = new Tree();
        arbol.createExample();
        arbol.inPreOrderViewTree();
        System.out.println("///////////");
        arbol.inOrderViewTree();
        System.out.println("///////////");
        arbol.inPostOrderViewTree();
    }
}