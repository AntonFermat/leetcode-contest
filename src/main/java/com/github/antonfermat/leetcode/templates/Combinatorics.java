package com.github.antonfermat.leetcode.templates;

public class Combinatorics {
    private static final int mod = 1_000_000_007;

    // Binomial coefficient / Pascal triangle
    // C(n, r) -> binomial[n][r]
    // For example, there are C(4, 2) = 6 ways to choose 2 elements from {1, 2, 3, 4}, namely {1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4}
    private static final long[][] binomial = new long[1001][1001];

    static {
        for (int i = 0; i < 1001; i++) {
            binomial[i][0] = 1;
            binomial[i][i] = 1;
        }

        for (int i = 2; i < 1001; i++) {
            for (int j = 1; j < i; j++) {
                binomial[i][j] = (binomial[i - 1][j - 1] + binomial[i - 1][j]) % mod;
            }
        }
    }

    /**
     * Binomial coefficient / Hard code = n! / k! * (n -k)!
     */
    private static long c(int n, int k) {
        long factN = 1;
        long factK = 1;
        long factNK = 1;
        for (int i = 1; i <= n; i++) {
            factN *= i;
            if (i == k) factK = factN;
            if (i == (n - k)) factNK = factN;
        }
        return factN / (factK * factNK);
    }

    private static long binomi(int n, int k) {
        if ((n == k) || (k == 0)) return 1;
        else return binomi(n - 1, k) + binomi(n - 1, k - 1);
    }

    private static long binomial(int n, int k) {
        if (k > n - k) k = n - k;
        long b = 1;
        for (int i = 1, m = n; i <= k; i++, m--) b = b * m / i;
        return b;
    }
}
