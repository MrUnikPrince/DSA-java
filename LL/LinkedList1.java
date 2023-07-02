import java.util.*;

public class LinkedList1 {
    // this one is node class which contains data and address of next node
    public class Node<t> {
        int data;
        Node<t> next;

        public Node(int data) {
            this.data = data;
            // this.next = next;
        }

    }

    public class DoubleNode {
        Node head;
        Node<Integer> tail;

        public DoubleNode(Node<Integer> head, Node<Integer> tail) {
            this.head = head;
            this.tail = tail;
        }

    }

    // this function is used to print linked list
    public static void print(Node<Integer> head) {
        Node<Integer> temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
    }

    // this function returns length of LinkedList
    public static int length(Node<Integer> head) {
        if (head == null) {
            return 0;
        }
        Node<Integer> temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // this function takes LinkedList as input form user
    public Node<Integer> takeInput() {
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        Node<Integer> head = null, tail = null;
        while (data != -1) {
            Node<Integer> newNode = new Node<>(data);
            if (head == null) {
                head = tail = newNode;
            } else {

                tail.next = newNode;
                tail = newNode;
            }
            data = sc.nextInt();
        }
        return head;
    }

    // insert node in Linked list
    // make before break

    public Node<Integer> insert(Node<Integer> head, int pos, int data) {
        Node<Integer> targetNode = new Node<>(data);
        if (pos == 0) {
            targetNode.next = head;
            return targetNode;
        } else {
            int count = 1;
            Node<Integer> prev = head;
            while (count <= pos - 1 && prev != null) { // is want start indexing from '1' then write like this "count <
                                                       // pos -1"
                count++;
                prev = prev.next;
            }
            if (prev != null) {
                targetNode.next = prev.next;
                prev.next = targetNode;
            }
        }
        return head;

    }

    // inserting node in ll using recursion
    public Node<Integer> recursiveIsert(Node<Integer> head, int pos, int data) {
        Node<Integer> targetNode = new Node<>(data);
        if (head == null && pos > 0) {
            return head;
        }
        if (pos == 0) {
            targetNode.next = head;
            return targetNode;
        } else {
            head.next = recursiveIsert(head.next, pos - 1, data);
            return head;
        }

    }

    public Node<Integer> deletNodeRecursive(Node<Integer> head, int pos) {
        if (head == null && pos > 0) {
            return head;
        }

        if (pos == 0) {
            return head.next;
        } else {
            if (head.next == null) {
                return head;
            }
            head.next = deletNodeRecursive(head.next, pos - 1);
            return head;
        }
    }

    // in this function we are reversing linkedlist //O(n2)
    public static Node<Integer> reverseLinkedListRec(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node<Integer> smallHead = reverseLinkedListRec(head.next);
        Node<Integer> tail = smallHead;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = head;
        head.next = null;
        return smallHead;

    }

    // in this function we are reversing linkedlist //O(n)
    public static Node<Integer> reverseLinkedListRecImp(Node<Integer> head) {
        DoubleNode ans;
        if (head == null || head.next == null) {
            // ans = new DoubleNode(head,head);
        }
        Node<Integer> smallHead = reverseLinkedListRec(head.next);
        Node<Integer> tail = smallHead;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = head;
        head.next = null;
        return smallHead;

    }

    // writing a function to find node in ll using recursive function

    public static int findNodeRec(Node<Integer> head, int n) {
        

        if (head == null) {
            return -1;
        }
        int count = 0;
        if (head.data == n) {
            return count;
        }
        count++;
        findNodeRec(head.next, n);
        return count;

    }

    public static void main(String[] args) {
        LinkedList1 ll = new LinkedList1();
        Node<Integer> head = ll.takeInput();
        int ans = findNodeRec(head, 4);
        System.out.println(ans);

    }

    // public static int count = 0;
}