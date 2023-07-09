import java.util.*;

public class Inorder {
    static class node {
        int val;
        node left;
        node right;

        node() {
        }

        node(int val) {
            this.val = val;
        }

        node(int val, node left, node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static ArrayList<Integer> inOrder(node root) {

        ArrayList<Integer> inOrder = new ArrayList<>();
        if (root == null) {
            return inOrder;
        }
        // left check
        inOrder.addAll(inOrder(root.left));
        inOrder.add(root.val);
        inOrder.addAll(inOrder(root.right));

        return inOrder;
    }
    public static void main(String[] args) {
    
    }
}
