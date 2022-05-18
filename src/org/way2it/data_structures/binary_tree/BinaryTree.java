package org.way2it.data_structures.binary_tree;

import org.way2it.data_structures.linked_list.LinkedList;

public class BinaryTree {

    // Represents the first node of this tree
    // Should be initialized when first value is added
    private Node root;

    private int size = 0;

    public BinaryTree() {
    }

    // Should add new value to the tree according to binary tree rules:
    // Values that are less than or equal to the value in the current node, should be placed in the left subtree
    // Values that are greater than the value in the current node - should be placed in the right subtree
    public void add(int value) {
        Node node = new Node();
        Node currentNode = root;
        boolean endNode = false;
        if (root == null){
            root = node;
            root.value = value;
            root.deleted = false;
            size++;
        }
        else {
            while (!endNode) {
                if (value <= currentNode.value) {
                    if (currentNode.left == null) {
                        node.value = value;
                        currentNode.left = node;
                        currentNode.deleted = false;
                        size++;
                        endNode = true;
                    }
                    else {
                        currentNode = currentNode.left;
                    }
                } else {
                    if (currentNode.right == null) {
                        node.value = value;
                        currentNode.right = node;
                        currentNode.deleted = false;
                        size++;
                        endNode = true;
                    }
                    currentNode = currentNode.right;
                }

            }
        }
        // TODO implement me
    }

    // Should remove specified value from tree and return true
    // If value does not exist in this tree - return false
    public boolean remove(int value) {
        Node currentNode = root;
        currentNode.value = root.value;
        boolean out = false;
        while (currentNode != null) {
            if (value == currentNode.value) {
                out = true;
                currentNode.deleted = true;
                size--;
                break;
            } else if (value < currentNode.value) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }
        /*Node currentNode = root;
        Node rootTemp = null;
        Node currentTemp = rootTemp;
        boolean out = false;

        if (root.value == value){
            if (currentNode.right != null){
                root = currentNode.right;
                rootTemp = currentNode.left;
            }
            else if (currentNode.left !=null){
                root = currentNode.left;
            }
            else {
                root = null;
            }
            //System.out.println("root.value = " + root.value);
            //System.out.println("rootTemp.value = " + rootTemp.value);
            out = true;
            size--;
        }
        else if (root.value < value){

        }*/

        // TODO implement me
        return out;
    }

    // Should return true if this tree contains specified value, false - otherwise
    public boolean contains(int value) {
        Node currentNode = root;
        currentNode.value = root.value;
        boolean out = false;
        while (currentNode != null) {
            if (value == currentNode.value) {
                if (currentNode.deleted == false) {
                    out = true;
                }
                break;
            } else if (value < currentNode.value) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }
        // TODO implement me
        return out;
    }

    public int getSize() {
        return size;
    }

    private static class Node {
        int value;
        Node left;
        Node right;
        boolean deleted;
    }
}
