import java.util.LinkedList;

//  * Definition for singly-linked list.
   class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
 
public class nextnumber {
    public ListNode plusOne(ListNode head) {
        // Reverse the linked list
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        // Increment the number and keep track of carry
        int carry = 1;
        curr = prev;
        while (curr != null) {
            int sum = curr.val + carry;
            curr.val = sum % 10;
            carry = sum / 10;
            if (carry == 0) {
                break;
            }
            curr = curr.next;
        }
        
        // If there is a carry after processing all digits
        if (carry != 0) {
            ListNode newNode = new ListNode(carry);
            curr.next = newNode;
        }
        
        // Reverse the list again
        prev = null;
        curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        nextnumber nn = new nextnumber();
        
       
        
    }
}

