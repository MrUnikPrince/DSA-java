import java.util.*;
import java.util.concurrent.CountDownLatch;

public class StackB {

    // stack using arraylist
    static class stackb {
        static ArrayList<Integer> list = new ArrayList<>();

        // is Empty
        public static boolean isEmpty() {
            return list.size() == 0;
        }

        // is push
        public static void push(int data) {
            list.add(data);
        }

        // pop
        public static int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        // peek
        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            return list.get(list.size() - 1);
        }
    }
    // stack using Linked List

    static class node {
        int data;
        node next;

        node(int data) {
            this.data = data;
            this.next = next;
        }
    }

    static node head = null;

    static class stack {

        // Empty function
        public static boolean isEmpty() {
            return head == null;
        }

        // push
        public static void push(int data) {
            node newNode = new node(data);
            if (isEmpty()) {
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        // pop
        public static int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        // peek
        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            return head.data;
        }
        // get size
        public static int getSize() {
            int count =0;
            if (isEmpty()) {
                return count;
            }
            while(!isEmpty()){
                count++;
                pop();
            }
            return count;
        }
    }
    public static void main(String[] args) {
        stack s = new stack();
        s.push(4);
        s.push(3);
        s.push(2);
        s.push(1);

        // while (!s.isEmpty()) {
        //     System.out.println(s.peek());
        //     s.pop();
        // }
        System.out.println("size" + " " + s.getSize());
    }
}