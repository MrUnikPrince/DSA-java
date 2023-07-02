class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
    }
}
public class kReverse{

    public static LinkedListNode<Integer> kReverse(LinkedListNode<Integer> head, int k) {
        if (k == 0) { // base case
            return head;
        }
        LinkedListNode<Integer> current = head;
        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> next = null;
        int count = 0;

        // Reverse first k nodes of the linked list
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if (next != null) {
            // Recursively call kReverse for the rest of the list
            head.next = kReverse(next, k);
        }

        // prev is the new head of the input list
        return prev;
    }
    public static void main(String[] args) {
        
    }
}

