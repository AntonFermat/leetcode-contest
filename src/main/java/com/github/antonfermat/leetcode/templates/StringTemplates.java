package com.github.antonfermat.leetcode.templates;

public class StringTemplates {

    // CONSTANTS
    // RADIX alphabet's size
    // MOD - big prime number
    int RADIX = 26;
    int MOD = 1000000033;

    /**
     * Rolling hash / Rabin - Karp
     */
    public int rollingHash(String string, int RADIX, int MOD, int m) {
        int res = 0;
        long factor = 1;
        for (int i = m - 1; i >= 0; i--) {
            res += ((string.charAt(i) - 'a') * factor) % MOD;
            factor = (factor * RADIX) % MOD;
        }
        return res % MOD;
    }
}
