package tree_excercise_int;

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
        tree.preorder(tmp);
        System.out.println("");

        //Test inorder(Node p)
        System.out.println("\n7.Test inorder(Node p)");
        tree.clear();
        tree.insertAll(a);
        tree.inorder(tmp);
        System.out.println("");

        //Test postorder(Node p)
        System.out.println("\n8.Test postorder(Node p)");
        tree.clear();
        tree.insertAll(a);
        tree.postOrder(tmp);
        System.out.println("");

        //Test count(Node p)
        System.out.println("\n9.Test count(Node p)");
        tree.clear();
        tree.insertAll(a);
        System.out.println(tree.count(tmp));

        //Test delete(Node p, int value)
        System.out.println("\n10.Test delete(Node p, int value)");
        tree.clear();
        tree.insertAll(a);
        tmp = tree.delete(tmp, 70);
        tree.inorder(tmp);
        System.out.println("");

        //Test min(Node p)
        System.out.println("\n11.Test min(Node p)");
        tree.clear();
        tree.insertAll(a);
        System.out.println(tree.min(tmp));

        //Test max(Node p)
        System.out.println("\n12.Test max(Node p)");
        tree.clear();
        tree.insertAll(a);
        System.out.println(tree.max(tmp));

        //Test sum(Node p)
        System.out.println("\n13.Test sum(Node p)");
        tree.clear();
        tree.insertAll(a);
        System.out.println(tree.sum(tmp));

        //Test avg(Node p)
        System.out.println("\n14.Test avg(Node p)");
        tree.clear();
        tree.insertAll(a);
        System.out.println(tree.avg(tmp));

        //Test maxDepth(Node p)
        System.out.println("\n15.Test maxDepth(Node p)");
        tree.clear();
        tree.insertAll(a);
        System.out.println(tree.maxDepth(tmp));

        //Test sumOfLongRootToLeafPathUtil(Node p)
        System.out.println("\n16.Test sumOfLongRootToLeafPathUtil(Node p)");
        tree.clear();
        tree.insertAll(a);
        System.out.println(tree.sumOfLongRootToLeafPathUtil(tmp));

        //Test isAVL(Node p)
        System.out.println("\n17.Test isAVL(Node p)");
        tree.clear();
        tree.insertAll(a);
        System.out.println(tree.isAVL(tmp));

        //Test mystery(Node p)
        System.out.println("\n18.Test mystery(Node p)");
        tree.clear();
        int b[] = {4, 2, 1, 3, 9, 5, 6, 12, 11, 15};
        tree.insertAll(b);
        System.out.println(tree.mystery(tmp));
        tree.clear();
        int c[] = {7, 5, 2, 1, 3, 6, 9, 8, 10, 12};
        tree.insertAll(c);
        System.out.println(tree.mystery(tmp));

        //Test isHeap(Node p)
        System.out.println("\n19.Test isHeap(Node p)");
        tree.clear();
        tree.insertAll(a);
        System.out.println(tree.isHeap(tmp));
    }

}
