package BTreeSearch;

import java.util.ArrayList;
import java.util.Stack;

public class Bts {
    // node class
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    private static Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (root.data > data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }

        return root;
    }

    public static boolean searchFunction(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data > key) {
            return searchFunction(root.left, key);
        }
        return searchFunction(root.right, key);
    }

    public static void printInRange(Node root, int k1, int k2) {
        if(root == null){
            return;
        }    
        if(root.data >= k1 && root.data <= k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        }else if(root.data < k1){
            printInRange(root.left, k1, k2);
        }else{
            printInRange(root.right, k1, k2);
        }    
    }
    // helper function
    public static Node findInorderSuccessorNode(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
    public static Node delNode(Node root, int data){
        if(root.data < data){
            root.right = (delNode(root.right, data));
        }else if(root.data > data){
            root.left = delNode(root.left, data);
        }else{
            //case 1: leaf Node
             if(root.left == null && root.right == null){
                return null;
             }
             // case 2: single child
             if(root.left == null){
                return root.right;
             }else if(root.right == null){
                return root.left;
             }
             // case 3: both children
             Node IS = findInorderSuccessorNode(root.right);
             root.data = IS.data;
             root.right = delNode(root.right, IS.data);
             
        }
        return root;
    }
    public static void print2Path(Node root, ArrayList<Integer> path) {
        if(root == null){
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null){
            printPath(path);
        }        
        print2Path(root.left, path);
        print2Path(root.right, path);
        path.remove(path.size()-1);
    }
    private static void printPath(ArrayList<Integer> path) {
        for(int i=0; i<path.size(); i++){
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
    }
    public static boolean isValidBst(Node root, Node min, Node max) {
        if(root == null){
            return true;
        }        
        if(min != null && root.data <= min.data){
            return false;
        }else if(max != null && root.data >= max.data){
            return false;
        }
        return isValidBst(root.left, min, root) && isValidBst(root.right, root, max);

    }
    public static Node mirorBST(Node root) {
        if(root == null){
            return null;
        }
        Node  lefts = mirorBST(root.left);
        Node rights = mirorBST(root.right);
        root.left  = rights;
        root.right = lefts;
        return root;        
    }
    public static void replaceWithLargerNodesSum(Node  root) {
		// Write your code here
		Stack<Node> s = new Stack<>();
        int sum =0;
        Node temp = root;
        while(temp != null || !s.isEmpty()){
            while(temp != null){
                s.push(temp);
                temp = temp.left;
            }

            temp = s.pop();
            sum += temp.data;
            temp.data = sum;
        }
        temp = temp.left;

	}
    public static void main(String[] args) {
        int datas[] = { 8,5,3,1,4,6,10,11,14 };
        Node root = null;
        for (int i = 0; i < datas.length; i++) {
            root = insert(root, datas[i]);
        }
       
        inorder(root);
        System.out.println();
        // printInRange(root, 5, 11);
        // inorder(root);
        // ArrayList<Integer> path = new ArrayList<>();
        // print2Path(root, path);
        // Node min = null;
        // Node max = null;
        System.out.println(mirorBST(root));
        inorder(root);
    }
}
