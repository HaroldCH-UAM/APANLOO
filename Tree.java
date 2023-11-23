package com.example;

public class Tree {
    private Node root;
    public Tree() {
        root = null;
    }
    public void createExample(){
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
        if(node == null) {
            return;
        }
        System.out.println(node.info);
        inPreOrder(node.left);
        inPreOrder(node.right);
    }

    public void inPreOrderViewTree(){
        inPreOrder(root);
    }
    private void inOrder(Node node) {
        if(node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.info);
        inOrder(node.right);
    }

    public void inOrderViewTree(){
        inOrder(root);
    }
    private void inPostOrder(Node node) {
        if(node == null) {
            return;
        }
        inPostOrder(node.left);
        inPostOrder(node.right);
        System.out.println(node.info);
    }

    public void inPostOrderViewTree(){
        inPostOrder(root);
    }
    
}
