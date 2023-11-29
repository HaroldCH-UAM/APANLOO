package com.example;
public class Tree {
  private Node root;
  int i;
  public Tree() {
    root = null;
  }
  public Tree(String s){
    i = 0;
    if(s.length() == 0) root = null;
    else root = fromString((s+'%').toCharArray());

  }
  public Node fromString(char[] s){
    Node aux  = new Node(s[i++]);
    if(s[i] != '('){
      return aux;

    }
    i++;
    if(s[i] == ','){
      aux.right = fromString(s);
      i++;
      return aux;

    }
    aux.left = fromString(s);
    if(s[i] != ','){
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
  private String inPostOrderS(Node node){
    String aux = "";
    if(node == null){return "";}
    if(node.left != null){
      aux = inPostOrderS(node.left);
    }
    if(node.right!= null){
      if(node.left != null){
        aux += ", " + inPostOrderS(node.right);
      }else{
        aux = inPostOrderS(node.right);
      }
    }
    if(node.left != null || node.right != null){
      aux += ", " + node.info;
    } else {
      aux += ""+node.info;
    }
    return aux;
  }

  public String inPostOrderS(){
    return inPostOrderS(root);
  }
  private int countNodes(Node node){
    if(node == null ) return 0;
    return 1 + countNodes(node.left) + countNodes(node.right);
  }
  public int countNodes(){
    return countNodes(root);
  }
  private int grade(Node node){
    if(node == null) return 0;
    return 1 + Math.max(grade(node.left), grade(node.right));
  }
  public int grade(){
    return grade(root);
  }
  private String leaveCount(Node node){
    if(node == null) return "";
    String aux = "";
    if(node.left == null && node.right == null){
      aux += node.info + ", ";
    }
    aux += leaveCount(node.left) + leaveCount(node.right);
    return aux;
  }
  public String leaveCount(){
    return leaveCount(root);
  }

  private String rootCount(Node node){
    if(node == null) return "";
    String aux = "";
    if(node.left != null || node.right != null){
      aux += node.info + ", ";
    }
    aux += rootCount(node.left) + rootCount(node.right);
    return aux;
  }
  public String rootCount(){
    return rootCount(root);
  }
  private boolean isDegenerated(Node node){
    if(node == null){return true;}
  if(node.left != null && node.right != null){return false;}
    return isDegenerated(node.left) && isDegenerated(node.right);
    
  }
  public boolean isDegenerated(){
    return isDegenerated(root);
  }
  public void creaDegenerado( ){
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
  private String byLevel(Node node, int level, String s){
    if(node == null) return s;
    if(level == 0){
      s += node.info + " ";
    }else{
      s = byLevel(node.left, level-1, s);
      s = byLevel(node.right, level-1, s);
    }
    return s;
    
  }
  public String byLevel(int level){
    return byLevel(root, level, "");
    
  }

  private int isComplete(Node node) {
    if(node == null) return 0;
    int i = isComplete(node.left);
    int j = isComplete(node.right);
    if(i == -1 || j == -1) return -1;
    if(i != j) return -1;
    return 1 + i;

  }
  public boolean isComplete(){
    return isComplete(root) != -1;
  }
  
  private Node clone(Node node){
    if(node == null) return null;
    Tree aux = new Tree();
    aux.root = new Node(node.info);
    aux.root.left = clone(node.left);
    aux.root.right = clone(node.right);
    return root;
  }
  public Tree clone(){
    Tree aux = new Tree();
    aux.root = clone(root);
    return aux;
  }
}
