public class mergeSort{
    public static class node{
        int data;
        node next;

        public node(int data) {
            this.data = data;
            // this.next = next;
        }

    }
    private static node getMid(node head){
        node slow = head;
        node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // mid node
    }
    private static node merge(node head1, node head2){
        node meargedll = new node(-1);
        node temp = meargedll;
        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1= head1.next;
                temp = temp.next;
            } else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return meargedll.next;
    }
    public static node mergeSort(node head) {
        if(head==null || head.next == null){
            return head;
        }
        //find Mid
            node mid = getMid(head);
        //left & right MS
        node rightHead = mid.next;
            mid.next = null;
        node newLeft = mergeSort(head);
        node newRight = mergeSort(rightHead);
        //merge
        return merge(newLeft, newRight);
        }
    public static void main(String[] args) {
        
    }
}