import java.util.Scanner;

public class ConsecutiveOnes {
    public static int countBinaryStrings(int n) {
        int[] a = new int[n + 1];
        a[0] = 1; // There is only 1 way to construct a string of length 0, i.e. an empty string.
        a[1] = 2; // There are 2 ways to construct a string of length 1, i.e. "0" or "1".

        // Recursively compute the number of strings without consecutive 1's.
        for (int i = 2; i <= n; i++) {
            a[i] = a[i-1] + a[i-2];
        }

        // Compute the number of strings with at least one consecutive 1's.
        int total = (int) Math.pow(2, n); // Total number of binary strings of length n.
        int noConsecutive = a[n]; // Number of binary strings of length n without consecutive 1's.
        int withConsecutive = total - noConsecutive; // Number of binary strings of length n with at least one consecutive 1's.
        return withConsecutive;
    }

    public static void printConsecutiveOnes(String binaryString) {
        int count = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                count++;
            } else {
                if (count > 1) {
                    System.out.println(count + " consecutive 1's starting at index " + (i - count));
                }
                count = 0;
            }
        }
        if (count > 1) {
            System.out.println(count + " consecutive 1's starting at index " + (binaryString.length() - count));
        }
    }
    public static int countNonConsecutiveOnes(int n) {
        final int MOD = 1000000007;
        int a = 1, b = 1;
        for (int i = 2; i <= n; i++) {
            int c = (a + b) % MOD;
            a = b;
            b = c;
        }
        return b;
    }
    
    public static int countNonConsecutiveOnesO(int n) {
        int[] a = new int[n + 1];
        a[0] = 1; // There is only 1 way to construct a string of length 0, i.e. an empty string.
        a[1] = 2; // There are 2 ways to construct a string of length 1, i.e. "0" or "1".
    
        // Recursively compute the number of strings without consecutive 1's.
        for (int i = 2; i <= n; i++) {
            a[i] = a[i-1] + a[i-2];
        }
    
        // Compute the number of strings without consecutive 1's.
        int total = (int) Math.pow(2, n); // Total number of binary strings of length n.
        int noConsecutive = a[n]; // Number of binary strings of length n without consecutive 1's.
        int withConsecutive = total - noConsecutive; // Number of binary strings of length n with at least one consecutive 1's.
        return withConsecutive;
    }
    
    public static void main(String[] args) {
        int n = 3;
        int count = countNonConsecutiveOnesO(n);
        System.out.println(count);
        generateBinaryStrings(n);
        // System.out.println("Number of binary strings of length " + n + " with consecutive 1's: " + count);
        // String binaryString = "1101110011";
        // printConsecutiveOnes(binaryString);
        // System.out.println(countNonConsecutiveOnes(1));
    }
    public static int countBinaryStringsOPTI(int n) {
        int a = 1, b = 1; // Initialize variables as 1, for string of length 1.
        int mod = 1000000007; // Modulo value to avoid integer overflow.
        
        for (int i = 2; i <= n; i++) {
            int temp = a;
            a = (a + b) % mod; // Compute a using the formula a = a + b.
            b = (temp) % mod; // Compute b using the formula b = a(i-1) (i.e. b = previous value of a).
        }
        
        int total = (a + b) % mod; // Compute the total number of binary strings of length N.
        return total;
    }
    public static void generateBinaryStrings(int K) {
        generate("", 0, K);
    }
    
    public static void generate(String str, int count, int K) {
        if (str.length() == K) {
            System.out.print(str + " ");
            count++;
            return;
        }
        generate(str + "0", count, K);
        if (str.length() == 0 || str.charAt(str.length() - 1) != '1') {
            generate(str + "1", count, K);
        }
    }
    
    
}
