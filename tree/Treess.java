import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Treess {

    public static class Node {
        int val;
        List<Node> children;

        public Node(int val) {
            this.val = val;
            this.children = new ArrayList<Node>();
        }
    }

    public static void printPreorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        for (Node child : node.children) {
            printPreorder(child);
        }
    }

    public static void printInorder(Node node) {
        if (node == null) {
            return;
        }
        for (Node child : node.children) {
            printInorder(child);
        }
        System.out.print(node.val + " ");
    }

    public static void printPostorder(Node node) {
        if (node == null) {
            return;
        }
        for (Node child : node.children) {
            printPostorder(child);
        }
        System.out.print(node.val + " ");
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node child1 = new Node(2);
        Node child2 = new Node(3);
        Node child3 = new Node(4);
        Node child4 = new Node(5);

        root.children.add(child1);
        root.children.add(child2);
        root.children.add(child3);
        root.children.add(child4);

        Node grandchild1 = new Node(6);
        Node grandchild2 = new Node(7);
        Node grandchild3 = new Node(8);
        Node grandchild4 = new Node(9);

        child1.children.add(grandchild1);
        child2.children.add(grandchild2);
        child3.children.add(grandchild3);
        child4.children.add(grandchild4);

        printPreorder(root);
        System.out.println();
        printInorder(root);
        System.out.println();
        printPostorder(root);
        System.out.println();
    }
}