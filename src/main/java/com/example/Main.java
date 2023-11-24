package com.example;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    Tree arbol = new Tree();
    arbol.createExample();

    System.out.println(arbol.inPreOrderS());
    System.out.println("///////////");

    System.out.println(arbol.inOrderS());
    System.out.println("///////////");

    System.out.println(arbol.inPostOrderS());
    System.out.println("///////////");
    System.out.println(arbol.countNodes());
    System.out.println("///////////");
    System.out.println(arbol.grade());
    System.out.println("///////////");
    System.out.println(arbol.leaveCount());
    System.out.println("///////////");
    System.out.println(arbol.rootCount());
    System.out.println("///////////");
      System.out.println(arbol.isDegenerated());
    Tree degenerado = new Tree();
    degenerado.creaDegenerado();
      System.out.println(degenerado.isDegenerated());
    

  }
}