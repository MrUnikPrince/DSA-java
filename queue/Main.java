package queue;
public class Main{
    static class Queue{
        static int arr[];
        static int size;
        static int rear;
        public Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }
        static boolean isEmpty() {
            return rear == -1;
        }
        public static void add(int data) {
            if(rear == size-1){
                System.out.println("Queue is full");
                return;
            }
            rear++;
            arr[rear] = data;
        }
        static int remove() {
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            int front = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i+1];               
            }
            rear--;
            return front;
        }
        static int peek() {
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            return arr[0];
        }
        
    }
    static class CircularQueue{
        static int arr[];
        static int size;
        static int rear;
        static int front;
        public CircularQueue(int n) {
            arr = new int[n];
            size = n;
            rear =-1;
            front =-1;
        }
        static boolean isEmpty() {
            return rear == -1 && front == -1;
        }
        static boolean isFull(){
            return (rear + 1) % size == front;
        }
        static void add(int data){
            if(isFull()){
                System.out.println("Queue is Full");
                return;
            }
            // first element
            if(front == -1){
                front++;
            }
            rear = (rear+1) % size;
            arr[rear] = data;
        }
        static int remove(){
            if(isEmpty()){
                System.out.println("Queue is Full");
                return -1;  
            }
            int result = arr[front];
            
            if(rear == front){
                rear = front = -1;
            }else{
                front = (front +1) % size;
            }
            return result;
        }
        static int peek(){
            if(isEmpty()){
                System.out.println("Queue is Full");
                return -1;  
            }
            return arr[front];
        }
    }
    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }

    }
}