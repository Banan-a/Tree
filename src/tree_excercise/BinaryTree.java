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

    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(" " + node.value);
        }
    }

    public int count(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + count(root.left) + count(root.right);
    }

    public Node delete(Node root, int value) {
        if (root == null) {
            return root;
        }
        if (value < root.value) {
            root.left = delete(root.left, value);
        } else if (value > root.value) {
            root.right = delete(root.right, value);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.value = min(root.right);
            root.right = delete(root.right, root.value);
        }
        return root;
    }

    public int min(Node root) {
        int minv = root.value;
        while (root.left != null) {
            minv = root.left.value;
            root = root.left;
        }
        return minv;
    }

    public int max(Node root) {
        int maxv = root.value;
        while (root.right != null) {
            maxv = root.right.value;
            root = root.right;
        }
        return maxv;
    }

    public int sum(Node root) {
        if (root == null) {
            return 0;
        }
        return (root.value + sum(root.left)
                + sum(root.right));
    }

    public int avg(Node root) {
        return sum(root) / count(root);
    }
}
