public class evenOddLL {
    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;
    
        public LinkedListNode(T data) {
            this.data = data;
        }
    }
    
    public static LinkedListNode<Integer> evenAfterOdd(LinkedListNode<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }

        LinkedListNode<Integer> oddHead = null, oddTail = null;
        LinkedListNode<Integer> evenHead = null, evenTail = null;

        LinkedListNode<Integer> curr = head;

        while (curr != null) {
            if (curr.data % 2 == 0) { // Even node
                if (evenHead == null) {
                    evenHead = curr;
                    evenTail = curr;
                } else {
                    evenTail.next = curr;
                    evenTail = evenTail.next;
                }
            } else { // Odd node
                if (oddHead == null) {
                    oddHead = curr;
                    oddTail = curr;
                } else {
                    oddTail.next = curr;
                    oddTail = oddTail.next;
                }
            }
            curr = curr.next;
        }

        // Join odd and even lists
        if (oddHead == null) { // No odd nodes
            return evenHead;
        } else {
            oddTail.next = evenHead;
            if (evenTail != null) {
                evenTail.next = null;
            }
            return oddHead;
        }
    }
    public static void main(String[] args) {
        
    }
}
