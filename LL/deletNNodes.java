
    // Following is the Node class already written for the Linked List

    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;
    
        public LinkedListNode(T data) {
            this.data = data;
        }
    }


public class deletNNodes {
    public static LinkedListNode<Integer> skipMdeleteN(LinkedListNode<Integer> head, int M, int N) {
        // edge cases: empty list or M or N equals 0
        if (head == null || M == 0) {
            return head;
        }
        
        if (N == 0) {
            return null;
        }
        
        LinkedListNode<Integer> current = head;
        LinkedListNode<Integer> tail = null;
        
        while (current != null) {
            // skip M nodes
            for (int i = 1; i < M && current != null; i++) {
                current = current.next;
            }
            
            if (current == null) {
                return head;
            }
            
            // set tail to the current node
            tail = current;
            // move current to the next node
            current = current.next;
            
            // delete N nodes
            for (int i = 1; i <= N && current != null; i++) {
                current = current.next;
            }
            
            // connect tail to current node
            tail.next = current;
        }
        
        return head;
    }
}

