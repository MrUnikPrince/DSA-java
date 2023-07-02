package methods;

class MethodsClass {
     // Fibonachhi 

     public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
    // with DP [O(n)]
    public static int fibWDp(int n, int DP[]) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (DP[n] != 0) {
            return DP[n];
        }
        DP[n] = fibWDp(n - 1, DP) + fibWDp(n - 2, DP);
        return DP[n];
    }
    public static int staircase(int n) {
		int dp[] = new int [n+1];
        dp[0]= 1;
        for(int i=1; i< n; i++){
            if(i==1){
                dp[i] = dp[i-1]+0;
            }
            dp[n]= dp[n-1]+ dp[n-2];
        }
        return dp[n];
	}

    // climb stair problem
    public static int climbStair(int n, int dp[]) {
        if (n == 0) {
            return 1;
        }
        if (n <= 0) {
            return 0;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = climbStair(n - 1, dp) + climbStair(n - 2, dp) + climbStair(n - 3, dp);
        return dp[n];
    }

    // tabulation 
    public static long staircasetabu(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1] + 0;
            } else if (i == 2) {
                dp[i] = dp[i - 1] + dp[i - 2] + 0;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
        }
        return dp[n];
    }
       // using recursion
       public static int countMinStepsToOneR(int n) {
		if (n == 1) {
        return 0;
    }
    // Recursive case
    int minSteps = countMinStepsToOneR(n - 1);
    if (n % 2 == 0) {
        int stepsToDivideBy2 = countMinStepsToOneR(n / 2);
        minSteps = Math.min(minSteps, stepsToDivideBy2);
    }
    if (n % 3 == 0) {
        int stepsToDivideBy3 = countMinStepsToOneR(n / 3);
        minSteps = Math.min(minSteps, stepsToDivideBy3);
    }
    // Add 1 to the minimum steps to account for the current operation
    return 1 + minSteps;	
	}

     // DP using tabulation
    // iteratative     
    
    public static int countMinStepsToOne(int n) {
        if (n == 1) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
        return dp[n];
    }
}
