import java.security.PublicKey;
import java.util.Stack;

public class ValidParentheses {
    public static boolean isBalanced(String str) {
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            // opening
            if(ch == '(' || ch == '{' || ch == '['){
                s.push(ch);
            }else{
                //closing
                if(s.isEmpty()){
                    return false;
                }
                if((s.peek() == '(' && ch == ')') || (s.peek() == '{' && ch == '}') || (s.peek() == '[' && ch == ']') ){
                    s.pop();
                }else{
                    return false;
                }
            }
        }
        if(s.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    public static void nextGreater(int arr[]) {
        Stack<Integer> s = new Stack<>();
        int nxtGreater[] = new int[arr.length];
        for(int i= arr.length-1; i>=0; i--){
            //1 while
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
                s.pop();
            }
            // if else
            if(s.isEmpty()){
                nxtGreater[i] = -1;
            }else{
                nxtGreater[i] = arr[s.peek()];
            }
            // push in s
            s.push(i);
        }
        for(int i=0; i<nxtGreater.length; i++){
            System.out.print(nxtGreater[i] + " ");
        }        
    }
    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            //closing
            if(ch == ')'){
                int count = 0;
                while(s.pop() != '('){
                    count++;
                }
                if(count < 1){
                    return true;// duplicate
                }
            }else{
                // opening 
                s.push(ch);
            }
        }
        return false;        
    }
    
    public static void main(String[] args) {
        String str = "((a+b))";
      
        System.out.println(isDuplicate(str));     
    }
}
