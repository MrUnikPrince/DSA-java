import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SackUsingQueues{
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(2);
        q.add(4);
        q.add(5);
        q.add(6);
        System.out.println(q);
        q.remove();
        System.out.println(q);
        System.out.println(q.peek());
        System.out.println();

        
    }
      
}
class MyStack {

    public MyStack() {
        Stack<Integer> s = new Stack<>();
    }
    
    public void push(int x) {
                
    }
    
    public int pop() {
        return 0;
        
    }
    
    public int top() {
        return 0;
        
    }
    
    // public boolean empty() {
    //     if(s.isEmpty){
    //         return true;
    //     }
    // }
}