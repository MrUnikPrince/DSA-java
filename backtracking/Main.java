import java.util.Scanner;

public class Main {
    private static final long MOD = 998244353;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            int r = scanner.nextInt();

            // Calculate the number of ways to place politicians and economists
            long ans = ncr(p + q, r);

            // Subtract the number of ways to place only economists in the rooms
            for (int i = 1; i < r; i++) {
                ans = (ans - (ncr(q, i) * ncr(p, r - i)) % MOD + MOD) % MOD;
            }

            System.out.println(ans);
        }

        scanner.close();
    }

    // Calculate nCr modulo MOD using Fermat's Little Theorem
    private static long ncr(int n, int r) {
        if (r == 0) {
            return 1;
        }

        long[] fact = new long[n + 1];
        fact[0] = 1;

        for (int i = 1; i <= n; i++) {
            fact[i] = (i * fact[i - 1]) % MOD;
        }

        long invR = pow(fact[r], MOD - 2);
        long invNMinusR = pow(fact[n - r], MOD - 2);

        return (((fact[n] * invR) % MOD) * invNMinusR) % MOD;
    }

    // Calculate a^b modulo MOD using binary exponentiation
    private static long pow(long a, long b) {
        long res = 1;

        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res * a) % MOD;
            }

            a = (a * a) % MOD;
            b >>= 1;
        }

        return res;
    }
}