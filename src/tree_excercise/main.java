/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree_excercise;

/**
 *
 * @author Bana-na
 */
public class main {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int a[] = {2, 90, 63, 70, 68, 72, 57};
        int x;
        Node tmp;

        //Test isEmpty()
        System.out.println("1.Test isEmpty()");
        System.out.println(tree.isEmpty());
        System.out.println("After add Array a");
        tree.insertAll(a);
        System.out.println(tree.isEmpty());
        System.out.println("");

        //Test clear()
        System.out.println("2.Test clear()");
        tree.traversal();
        System.out.println("After clear");
        tree.clear();
        System.out.println(tree.isEmpty());
        System.out.println("");

        //Test search(int x)
        System.out.println("3.Test search(int x)");
        tree.clear();
        tree.insertAll(a);
        x = 63;
        tmp = tree.search(x);
        System.out.println(tmp);
        System.out.println("");

        //Test insert(int x)
        System.out.println("4.Test insert(int x)");
        tree.clear();
        tree.insertAll(a);
        x = 44;
        tree.insert(x);
        tree.traversal();
        System.out.println("");

        //Test traversal()
        System.out.println("\n5.Test traversal()");
        tree.clear();
        tree.insertAll(a);
        tree.traversal();
        System.out.println("");

        //Test preoder(Node p)
        System.out.println("\n6.Test preoder(Node p)");
        tree.clear();
        tree.insertAll(a);
        x = 63;
        tmp = tree.search(x);
        tree.preorder(tmp);
        System.out.println("");

        //Test inorder(Node p)
        System.out.println("\n7.Test inorder(Node p)");
        tree.clear();
        tree.insertAll(a);
        x = 63;
        tmp = tree.search(x);
        tree.inorder(tmp);
        System.out.println("");

    }

}
