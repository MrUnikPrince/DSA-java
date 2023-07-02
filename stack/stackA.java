import java.util.Stack;

public class stackA {
    // push at the bottom of the stack
    public static void pushAtBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.peek();
        pushAtBottom(s, data);
        s.push(top);
    }

    // reverse a Stack

    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    // Revers a String using a Stack Ex:- "abc" -> "cba"

    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while (idx < str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder result = new StringBuilder();
        while (!s.isEmpty()) {
            char curr = s.pop();
            result.append(curr);
        }
        return result.toString();
    }

    public static void reverseStack(Stack<Integer> input, Stack<Integer> extra) {
        Stack<Integer> helper = new Stack<>();
        while (!input.isEmpty()) {
             int element = input.pop();
             extra.push(element);
         }
         while (!extra.isEmpty()) {
             int element = extra.pop();
             helper.push(element);
     }
         while (!helper.isEmpty()) {
             int element = helper.pop();
             input.push(element);
         }       
	}

    public static void main(String[] args) {
        // stack using collections Framework
        Stack<Integer> s = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        s.push(10);
        s.push(5);
        s.push(4);
        s.push(3);
        s.push(2);
        s.push(1);
        System.out.println(s);
        reverseStack(s, s2);
        System.out.println(s);
        System.out.println(s2);
        // s.add(3, 7);
        // System.out.println(s.lastElement());
        // System.out.println("hii there ");

        // print(s2);
        // System.out.println("hii there ");
        // reverseStack(s, s2);
        // String str1 = reverseString("abc");
        // System.out.println(str1);
        // System.out.println(s.get(3));
        // print(s);

    }

    public static void print(Stack<Integer> s) {

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
