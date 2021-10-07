/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree_excercise;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Bana-na
 */
public class BinaryTree {

    Node root;

    public BinaryTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void clear() {
        root = null;
    }

    private Node containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }
        if (value == current.value) {
            return current;
        }
        return value < current.value
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    public Node search(int x) {
        return containsNodeRecursive(root, x);
    }

    private Node insertRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = insertRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = insertRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    public void insert(int x) {
        root = insertRecursive(root, x);
    }

    public void insertAll(int a[]) {
        for (int i = 0; i < a.length; i++) {
            insert(a[i]);
        }
    }

    public void traversal() {
        if (root == null) {
            return;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {

            Node node = nodes.remove();

            System.out.print(" " + node.value);

            if (node.left != null) {
                nodes.add(node.left);
            }

            if (node.right != null) {
                nodes.add(node.right);
            }
        }
    }

    public void preorder(Node p) {
        if (p == null) {
            return;
        }

        System.out.print(p.value + " ");

        preorder(p.left);

        preorder(p.right);
    }

    public void inorder(Node p) {
        if (p == null) {
            return;
        }

        inorder(p.left);

        System.out.print(p.value + " ");

        inorder(p.right);
    }

}
