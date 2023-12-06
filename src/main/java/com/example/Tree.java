package com.example;

import java.util.*;

public class Tree {
  Node root;
  int i;

  public Tree() {
    root = null;
  }

  public Tree(String s) {
    i = 0;
    if (s.length() == 0)
      root = null;
    else
      root = fromString((s + '%').toCharArray());

  }

  public Node fromString(char[] s) {
    Node aux = new Node(s[i++]);
    if (s[i] != '(') {
      return aux;

    }
    i++;
    if (s[i] == ',') {
      aux.right = fromString(s);
      i++;
      return aux;

    }
    aux.left = fromString(s);
    if (s[i] != ',') {
      return aux;
    }
    i++;
    aux.right = fromString(s);
    i++;
    return aux;
  }

  public void createExample() {
    root = new Node('A');

    root.left = new Node('B');
    root.right = new Node('C');

    root.left.left = new Node('D');
    root.right.left = new Node('E');
    root.right.right = new Node('F');

    root.left.left.right = new Node('G');
    root.right.left.left = new Node('H');
    root.right.left.right = new Node('I');
  }

  private void inPreOrder(Node node) {
    if (node == null) {
      return;
    }
    System.out.println(node.info);
    inPreOrder(node.left);
    inPreOrder(node.right);
  }

  public void inPreOrderViewTree() {
    inPreOrder(root);
  }

  private void inOrder(Node node) {
    if (node == null) {
      return;
    }
    inOrder(node.left);
    System.out.println(node.info);
    inOrder(node.right);
  }

  public void inOrderViewTree() {
    inOrder(root);
  }

  private void inPostOrder(Node node) {
    if (node == null) {
      return;
    }
    inPostOrder(node.left);
    inPostOrder(node.right);
    System.out.println(node.info);
  }

  public void inPostOrderViewTree() {
    inPostOrder(root);
  }

  private String inOrderS(Node node) {
    if (node == null) {
      return "";
    }
    String aux = "";
    if (node.left != null) {
      aux = inOrderS(node.left) + ", ";
    }
    aux += node.info;
    if (node.right != null) {
      aux += ", " + inOrderS(node.right);
    }
    return aux;
  }

  public String inOrderS() {
    return inOrderS(root);
  }

  private String inPreOrderS(Node node) {
    if (node == null) {
      return "";
    }
    String aux = "" + node.info;
    if (node.left != null) {
      aux += ", " + inPreOrderS(node.left);
    }

    if (node.right != null) {
      aux += ", " + inPreOrderS(node.right);
    }
    return aux;
  }

  public String inPreOrderS() {
    return inPreOrderS(root);
  }

  private String inPostOrderS(Node node) {
    String aux = "";
    if (node == null) {
      return "";
    }
    if (node.left != null) {
      aux = inPostOrderS(node.left);
    }
    if (node.right != null) {
      if (node.left != null) {
        aux += ", " + inPostOrderS(node.right);
      } else {
        aux = inPostOrderS(node.right);
      }
    }
    if (node.left != null || node.right != null) {
      aux += ", " + node.info;
    } else {
      aux += "" + node.info;
    }
    return aux;
  }

  public String inPostOrderS() {
    return inPostOrderS(root);
  }

  private int countNodes(Node node) {
    if (node == null)
      return 0;
    return 1 + countNodes(node.left) + countNodes(node.right);
  }

  public int countNodes() {
    return countNodes(root);
  }

  private int grade(Node node) {
    if (node == null)
      return 0;
    return 1 + Math.max(grade(node.left), grade(node.right));
  }

  public int grade() {
    return grade(root);
  }

  private String leaveCount(Node node) {
    if (node == null)
      return "";
    String aux = "";
    if (node.left == null && node.right == null) {
      aux += node.info + ", ";
    }
    aux += leaveCount(node.left) + leaveCount(node.right);
    return aux;
  }

  public String leaveCount() {
    return leaveCount(root);
  }

  private String rootCount(Node node) {
    if (node == null)
      return "";
    String aux = "";
    if (node.left != null || node.right != null) {
      aux += node.info + ", ";
    }
    aux += rootCount(node.left) + rootCount(node.right);
    return aux;
  }

  public String rootCount() {
    return rootCount(root);
  }

  private boolean isDegenerated(Node node) {
    if (node == null) {
      return true;
    }
    if (node.left != null && node.right != null) {
      return false;
    }
    return isDegenerated(node.left) && isDegenerated(node.right);

  }

  public boolean isDegenerated() {
    return isDegenerated(root);
  }

  public void creaDegenerado() {
    root = new Node('A');
    root.left = new Node('B');
    root.left.left = new Node('D');
    root.left.left.right = new Node('G');
    root.left.left.right.left = new Node('X');
  }

  private String parenthesisNotation(Node node) {
    if (node == null) {
      return "";
    }
    String aux = "";
    if (node.left == null && node.right == null) {
      aux = aux + node.info;
    }
    if (node.left != null && node.right == null) {
      aux = aux + node.info + "(" + parenthesisNotation(node.left) + ")";
    }
    if (node.left == null && node.right != null) {
      aux = aux + node.info + "(," + parenthesisNotation(node.right) + ")";
    }
    if (node.left != null && node.right != null) {
      aux = aux + node.info + "(" + parenthesisNotation(node.left) + "," + parenthesisNotation(node.right) + ")";
    }
    return aux;
  }

  @Override
  public String toString() {
    return parenthesisNotation(root);
  }

  private String byLevel(Node node, int level, String s) {
    if (node == null)
      return s;
    if (level == 0) {
      s += node.info + " ";
    } else {
      s = byLevel(node.left, level - 1, s);
      s = byLevel(node.right, level - 1, s);
    }
    return s;

  }

  public String byLevel(int level) {
    return byLevel(root, level, "");

  }

  private int isComplete(Node node) {
    if (node == null)
      return 0;
    int i = isComplete(node.left);
    int j = isComplete(node.right);
    if (i == -1 || j == -1)
      return -1;
    if (i != j)
      return -1;
    return 1 + i;

  }

  public boolean isComplete() {
    return isComplete(root) != -1;
  }

  private Node clone(Node node) {
    if (node == null)
      return null;
    Tree aux = new Tree();
    aux.root = new Node(node.info);
    aux.root.left = clone(node.left);
    aux.root.right = clone(node.right);
    return root;
  }

  public Tree clone() {
    Tree aux = new Tree();
    aux.root = clone(root);
    return aux;
  }

  private boolean isIdentical(Node node1, Node node2) {
    if (node1 == null && node2 == null)
      return true;
    if (node1 == null || node2 == null)
      return false;
    if (node1.info != node2.info)
      return false;
    return isIdentical(node1.left, node2.left) && isIdentical(node1.right, node2.right);
  }

  public boolean isIdentical(Tree tree) {
    return isIdentical(root, tree.root);
  }

  public void queuedByLevel() {
    Queue<Node> queue = new LinkedList<>();
    int nivel = 0;
    if (root == null)
      return;
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      System.out.println("Nivel: " + nivel++);
      for (int i = 0; i < size; i++) {
        Node node = queue.remove();
        System.out.println(node.info);
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
    }
  }

  public boolean isCompleteQueue() {
    Queue<Node> queue = new LinkedList<>();
    int nivel = 0;
    if (root == null)
      return true;
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      if (size != (int) Math.pow(size, nivel))
        return false;
      System.out.println("Nivel: " + nivel++);
      for (int i = 0; i < size; i++) {
        Node node = queue.remove();
        System.out.println(node.info);
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
    }
    return true;
  }

  public void recorrerCola() {
    Queue<Node> cola = new LinkedList<>();
    if (root == null)
      return;
    cola.add(root);
    int nivel = 0;
    while (!cola.isEmpty()) {
      int tam = cola.size();
      System.out.println("Nivel " + nivel++);
      for (int i = 0; i < tam; i++) {
        Node aux = cola.remove();
        System.out.println(aux.info);
        if (aux.left != null) {
          cola.add(aux.left);
        }
        if (aux.right != null) {
          cola.add(aux.right);
        }
      }
    }
  }

  public boolean esLlenoCola() {
    Queue<Node> cola = new LinkedList<>();
    int tam = cola.size();
    if (root == null)
      return true;
    cola.add(root);
    Boolean nulo = false;
    while (!cola.isEmpty()) {
      tam = cola.size();
      for (int i = 0; i < tam; i++) {
        Node aux = cola.remove();
        if (aux == null) {
          nulo = true;
          continue;
        }
        if (nulo) {
          return false;
        }
        System.out.println(aux.info);
        cola.add(aux.left);
        cola.add(aux.right);
      }

    }
    return true;
  }

  public boolean esCompletoCola() {
    Queue<Node> cola = new LinkedList<>();
    if (root == null)
      return true;
    cola.add(root);
    int nivel = 0;
    while (!cola.isEmpty()) {
      int tam = cola.size();
      if (tam != Math.pow(2, nivel))
        return false;
      for (int i = 0; i < tam; i++) {
        Node aux = cola.remove();
        if (aux.left != null) {
          cola.add(aux.left);
        }
        if (aux.right != null) {
          cola.add(aux.right);
        }
      }
    }
    return true;
  }

  private int[] state(int a, int b) {
    int[] e = { a, b };
    return e;
  }

  private int[] lleno(Node node) {
    if (node == null)
      return state(0, 0);
    int[] left = lleno(node.left);
    int[] right = lleno(node.right);
    if (left[0] == 2 || right[0] == 2)
      return state(2, 0);

    if (left[0] == 0 && right[0] == 0 && left[1] == right[1])
      return state(0, left[1] + 1);

    if (left[0] == 0 && right[0] == 1 && left[1] == right[1] + 1)
      return state(1, left[1] + 1);

    if (left[0] == 0 && right[0] == 1 && left[1] == right[1])
      return state(1, left[1] + 1);

    if (left[0] == 1 && right[0] == 0 && left[1] == right[1] + 1)
      return state(1, left[1] + 1);

    return state(2, 0);

  }

  public boolean esLleno() {
    return lleno(root)[0] < 2;
  }

  private Node insertaOrdenado(Node node, char info) {
    if (node == null)
      return new Node(info);
    if (info <= node.info) {
      node.left = insertaOrdenado(node.left, info);
    } else {
      node.right = insertaOrdenado(node.right, info);
    }
    return node;

  }

  public void insertaOrdenado(char info) {
    root = insertaOrdenado(root, info);
  }
  private boolean busqueda(Node node, char info) {
    if (node == null)
      return false;
    if (node.info == info)
      return true;
    if (info <= node.info)
      return busqueda(node.left, info);
    return busqueda(node.right, info);
  }

  public boolean busqueda(char info) {
    return busqueda(root, info);
  }

  private boolean ordenadoABB(Node node, char min, char max) {
    if (node == null) {
      return true;
    }
    return node.info >= min && node.info <= max && ordenadoABB(node.left, min, node.info)
        && ordenadoABB(node.right, (char) (node.info + 1), max);
  }

  public boolean ordenadoABB() {
    return ordenadoABB(root, Character.MIN_VALUE, Character.MAX_VALUE);
  }

  private Node borraRaiz(Node node) {
    if (node == null)
      return null;
    if (node.left == null)
      return node.right;
    if (node.right == null)
      return node.left;
    node.right = borraSucesor(node, node.right);
    // node.right = borraSucIterativo(node, node.right);
    return node;
  }

  private Node borraSucesor(Node superRoot, Node node) {
    if (node == null)
      return superRoot;
    if (node.left == null) {
      superRoot.info = node.info;
      return node.right;
    }
    node.left = borraSucesor(superRoot, node.left);
    return node;
  }
  private Node borraSucIterativo(Node superRoot, Node node){
    if (node == null)
      return superRoot;
    if (node.left == null) {
      superRoot.info = node.info;
      return node.right;
    }
    Node aux;
    for(aux = node; aux.left.left != null; aux = aux.left);
    superRoot.info = aux.left.info;
    aux.left = aux.left.right;
    return node;
  }
  public void borraSucesor(char info){
  }
  private Node buscaYBorra(Node node, char info){
    if(node == null) return null;
    if(node.info == info){
      return borraRaiz(node);
    }
    if(node.info > info){
      node.left = buscaYBorra(node.left, info);
    }else{
     node.right = buscaYBorra(node.right, info);
    }
    return node;
  }
  public void buscaYBorra(char info){
    root = buscaYBorra(root, info);
  }
  public void buscaYBorraIterativo(){
    borraSucIterativo(root, root);
  }
}