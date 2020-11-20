package com.practice.binary.search;

import com.practice.binary.search.BinarySearchTree;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello world");
        BinarySearchTree bst = new BinarySearchTree();
        boolean resp = bst.addNode(3);
        System.out.println( " Node added succesfully = " + resp + " tree size is" + bst.size());
        boolean removed =bst.remove(3);
        System.out.println("Node removed successfully = " + removed + " tree size is" + bst.size());

    }
}
