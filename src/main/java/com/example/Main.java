package com.example;

public class Main {
  public static void main(String[] args) {
    Tree arbol3 = new Tree();
    arbol3.insertaOrdenado('H');        
    arbol3.insertaOrdenado('P');
    arbol3.insertaOrdenado('L');
    arbol3.insertaOrdenado('G');
    arbol3.insertaOrdenado('B');
    arbol3.insertaOrdenado('K');
    arbol3.insertaOrdenado('Z');
    arbol3.insertaOrdenado('G');
    System.out.println(arbol3);
    System.out.println(arbol3.ordenadoABB());
    arbol3.buscaYBorra('G');
    System.out.println(arbol3);
    System.out.println(arbol3.ordenadoABB());
    arbol3.buscaYBorra('B');
    System.out.println(arbol3);
    System.out.println(arbol3.ordenadoABB());
    System.out.println("///////////");

    }
  }