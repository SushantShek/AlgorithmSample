package com.practice.binary.search;

public class BinarySearchTree <T extends Comparable<T>> {

    public Node root = null;
    public int numOfNodes=0;

    private class Node{
        T value;
        Node left, right;
        Node(Node left, Node right, T value){
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }
    // all public methods to be called from outside this class

    //add a node with value to the tree
    public boolean addNode(T val){
        if(!contain(root, val)){
            root = add(root, val);
            numOfNodes++;
            return true;
        }else
        return false;
    }
    //remove a node with value from tree
    public boolean remove(T val){
        if(!contain(root, val)){
            return false;
        }else {
            root =  remove(root, val);
            numOfNodes--;
            return true;
        }
    }
    //give the total number of nodes in the tree
    public int size(){
        return numOfNodes;
    }
    // check if a node with the given value exist in the tree
    public boolean contain(Node n,T val){
        if (n == null) return false;

        int cmp = val.compareTo(n.value);

        // Dig into the left subtree because the value we're
        // looking for is smaller than the current value
        if (cmp < 0) return contain(n.left, val);

            // Dig into the right subtree because the value we're
            // looking for is greater than the current value
        else if (cmp > 0) return contain(n.right, val);

            // We found the value we were looking for
        else return true;
    }

    // Computes the height of the tree, O(n)
    public int height() {
        return height(root);
    }

    private Node add(Node n, T val){
        if(n == null)
            n = new Node(null, null, val);

        if(val.compareTo(n.value) < 0){
            n.left =add(n.left, val);
        }
        else if (val.compareTo(n.value) > 0){
            n.right = add(n.right, val);
        }
        return n;
    }

    private Node remove(Node n, T val){
        if( val.compareTo(n.value) < 0){
            n.left = remove(n.left, val);
        } else if(val.compareTo(n.value) > 0){
            n.right = remove(n.right, val);
        }else {
            if(n.left == null){
                Node rightNode = n.right;
                n.left =null;
                n = null;
                return rightNode;
            }
        }
        return n;
    }

    // Recursive helper method to compute the height of the tree
    private int height(Node node) {
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

}
