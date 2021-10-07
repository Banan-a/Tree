package tree_excercise_string;

import java.util.LinkedList;
import java.util.Queue;

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

    private Node containsNodeRecursive(Node current, String value) {
        if (current == null) {
            return null;
        }
        if (value == current.value) {
            return current;
        }
        return value.compareTo(current.value) < 0
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    public Node search(String x) {
        return containsNodeRecursive(root, x);
    }

    private Node insertRecursive(Node current, String value) {
        if (current == null) {
            return new Node(value);
        }

        if (value.compareTo(current.value) < 0) {
            current.left = insertRecursive(current.left, value);
        } else if (value.compareTo(current.value) > 0) {
            current.right = insertRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    public void insert(String x) {
        root = insertRecursive(root, x);
    }

    public void insertAll(String a[]) {
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

    public Node delete(Node root, String value) {
        if (root == null) {
            return root;
        }
        if (value.compareTo(root.value) < 0) {
            root.left = delete(root.left, value);
        } else if (value.compareTo(root.value) > 0) {
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

    public String min(Node root) {
        String minv = root.value;
        while (root.left != null) {
            minv = root.left.value;
            root = root.left;
        }
        return minv;
    }

    public String max(Node root) {
        String maxv = root.value;
        while (root.right != null) {
            maxv = root.right.value;
            root = root.right;
        }
        return maxv;
    }

    public String sum(Node root) {
        if (root == null) {
            return "";
        }
        return (root.value + sum(root.left)
                + sum(root.right));
    }

    public int maxDepth(Node node) {
        if (node == null) {
            return 0;
        } else {
            /* compute the depth of each subtree */
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);

            /* use the larger one */
            if (lDepth > rDepth) {
                return (lDepth + 1);
            } else {
                return (rDepth + 1);
            }
        }
    }
    static int maxLen;
    static String maxSum;

    public static void sumOfLongRootToLeafPath(Node root, String sum,
            int len) {
        // if true, then we have traversed a
        // root to leaf path
        if (root == null) {
            // update maximum length and maximum sum
            // according to the given conditions
            if (maxLen < len) {
                maxLen = len;
                maxSum = sum;
            } else if (maxLen == len && maxSum.compareTo(sum) < 0) {
                maxSum = sum;
            }
            return;
        }

        // recur for left subtree
        sumOfLongRootToLeafPath(root.left, sum + root.value,
                len + 1);

        sumOfLongRootToLeafPath(root.right, sum + root.value,
                len + 1);

    }

    static String sumOfLongRootToLeafPathUtil(Node root) {
        // if tree is NULL, then sum is 0
        if (root == null) {
            return "";
        }

        maxSum = "";
        maxLen = 0;

        // finding the maximum sum 'maxSum' for the
        // maximum length root to leaf path
        sumOfLongRootToLeafPath(root, "", 0);

        // required maximum sum
        return maxSum;
    }

    public int height(Node node) {
        /* base case tree is empty */
        if (node == null) {
            return 0;
        }

        /* If tree is not empty then height = 1 + max of left
         height and right heights */
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public boolean isAVL(Node node) {
        int lh;
        /* for height of left subtree */

        int rh;
        /* for height of right subtree */

 /* If tree is empty then return true */
        if (node == null) {
            return true;
        }

        /* Get the height of left and right sub trees */
        lh = height(node.left);
        rh = height(node.right);

        if (Math.abs(lh - rh) <= 1
                && isAVL(node.left)
                && isAVL(node.right)) {
            return true;
        }

        /* If we reach here then tree is not height-balanced */
        return false;
    }

    int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        return (1 + countNodes(root.left)
                + countNodes(root.right));
    }

    boolean isCompleteUtil(Node root, int index,
            int number_nodes) {
        // An empty tree is complete
        if (root == null) {
            return true;
        }

        // If index assigned to current
        //  node is more than number of
        //  nodes in tree,  then tree is
        // not complete
        if (index >= number_nodes) {
            return false;
        }

        // Recur for left and right subtrees
        return isCompleteUtil(root.left,
                2 * index + 1,
                number_nodes)
                && isCompleteUtil(root.right,
                        2 * index + 2,
                        number_nodes);
    }

    boolean isHeapUtil(Node root) {
        //  Base case : single
        // node satisfies property
        if (root.left == null && root.right == null) {
            return true;
        }

        //  node will be in second last level
        if (root.right == null) {
            //  check heap property at Node
            //  No recursive call ,
            //  because no need to check last level
            return root.value.compareTo(root.left.value) >= 0;
        } else {
            //  Check heap property at Node and
            //  Recursive check heap property at left and
            //  right subtree
            if (root.value.compareTo(root.left.value) >= 0
                    && root.value.compareTo(root.right.value) >= 0) {
                return isHeapUtil(root.left)
                        && isHeapUtil(root.right);
            } else {
                return false;
            }
        }
    }

    boolean isHeap(Node root) {
        if (root == null) {
            return true;
        }

        // These two are used
        // in isCompleteUtil()
        int node_count = countNodes(root);

        if (isCompleteUtil(root, 0, node_count) == true
                && isHeapUtil(root) == true) {
            return true;
        }
        return false;
    }

    String max(String x, String y) {
        if (x.compareTo(y) > 0) {
            return x;
        }
        return y;
    }

    String mystery(Node x) {
        if (x == null) {
            return "empty String";
        } else {
            return max(mystery(x.left), mystery(x.right));
        }
    }
}
