import java.util.LinkedList;

public class linkedlist {
    public static node head;
    
    public class node{
        int data;
        node next;
        public node(int data){
            this.data= data;
            this.next= null;
        }
    }
    public  void addfirst(int data){
        node newNode = new node(data);
        if(head==null){
            head = newNode;
            return;
        }
        newNode.next=head;
        head= newNode;
    }
    public static void main(String[] args) {
        linkedlist ll = new linkedlist();
        ll.addfirst(1);
        ll.addfirst(2);
        ll.addfirst(3);
        LinkedList<Integer> lll = new LinkedList<>();

    }
}

