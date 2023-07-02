import java.util.*;

public class BinaryTree{
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
        // this function is use to make binary Tree
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left= buildTree(nodes);
            newNode.right= buildTree(nodes);
            return newNode;
        }
        // function to take input from user 

        //InOrder Traversals
        public static void inorder(Node root){
            if(root==null){
                return;
            }
            inorder(root.left);
            System.out.print(root.data  + " ");
            inorder(root.right);
        }

        //Post Order
        public static void postOrder(Node root){
            if(root==null){
                return;
            }
            postOrder(root.left);
            postOrder(root.right);            
            System.out.print(root.data  + " ");
            
        }
        //level Order

        public static void levelOrder(Node root){
            if (root ==  null){
                return;
            }
            Queue<Node> q =  new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode==null){
                    System.out.println();  
                    if(q.isEmpty()){
                        break;
                    } else{
                        q.add(null);
                        }   
                }else{
                    System.out.print(currNode.data + " ");    
                    if(currNode.left != null){
                        q.add(currNode.left);
                    } 
                    if(currNode.right != null){
                        q.add(currNode.right);
                    }

                }
                    
            }
        }

        // height of tree

        public static int height(Node root){
            if(root == null){
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);
            return Math.max(lh,rh)+1;
        }

        // count of nodes

        public static int countNodes(Node root){
            if(root == null){
                return 0;
            }
            int leftHt = countNodes(root.left);
            int rightHt = countNodes(root.right);
            return leftHt+rightHt+1;
        }

        // sum of nodes data

        public static int sumOfN(Node root){
            if(root == null){
                return 0;
            }
            int leftSum = sumOfN(root.left);
            int rightSum = sumOfN(root.right);
            return leftSum + rightSum + root.data;
        }
        // Diameter of a tree

        public static int diameter(Node root){
            if(root == null){
                return 0;
            }
            int leftDim =  diameter(root.left);
            int leftHt = height(root.left);
            int rightDim = diameter(root.right);
            int right = height(root.right);
            int selfDim = leftHt + right +1;
            return Math.max(selfDim, Math.max(leftDim,rightDim));
        }


        public static void mirrorBinaryTree(Node root){
            if(root==null){
                return;
            }
            Node rl=root.left;
            root.left=root.right;
            root.right=rl;
            mirrorBinaryTree(root.left);
            mirrorBinaryTree(root.right);
        }

        // Print nodes at distance k from node

        public static void nodesAtDistanceK(Node root, int node, int k) {
            if(root == null){
                return;
            }
            if(node==k){
                System.out.println(root.data);     
                return;
            }
            nodesAtDistanceK(root.left, node++, k);
            nodesAtDistanceK(root.right, node++, k);
        }


        
    public static void main(String[] args) {
        int nodes[]= {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = buildTree(nodes);
        System.out.println();     
        inorder(root);  
        System.out.println();     
        postOrder(root); 
        System.out.println();     
        levelOrder(root);  
        System.out.println(height(root));     
        System.out.println(countNodes(root));     
        System.out.println(sumOfN(root));     
        System.out.println(diameter(root));   
        nodesAtDistanceK(root, 3,3);  
    }   
}


