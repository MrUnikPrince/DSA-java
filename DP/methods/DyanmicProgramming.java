package methods;

public class DyanmicProgramming {
    public static void main(String[] args) {
        int[] weights = {10, 20, 30, 40, 50};
        int[] values = {100, 200, 300, 400, 500};
        System.out.println(knapsack(weights, values, weights.length, 100));

    }
    // recursive code for knapsack algorithm
    public static int knapsack(int[] weights, int[] values, int n , int w) {
        if(w ==0 || n == 0){
            return 0;
        }
        if(weights[n-1] <= w){
            // include
            int ans1 = values[n-1] + knapsack(weights, values, n-1, w - weights[n-1]);
            // exclude
            int ans2 = knapsack(weights, values, n-1,w);
            return Math.max(ans1, ans2);
        } else{
            return knapsack(weights, values, n-1,w);
        }

    }

}
