package com.github.antonfermat.leetcode.templates;

public class Backpack {
    public int backPackI_1(int maxSize, int[] value) {
        int[][] dp = new int[value.length + 1][maxSize + 1];
        for (int i = 1; i <= value.length; i++) {
            for (int j = 1; j <= maxSize; j++) {
                if (j >= value[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - value[i - 1]] + value[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[value.length][maxSize];
    }

    public int backPackI_2(int maxSize, int[] size) {
        int[] dp = new int[maxSize + 1];
        for (int i = 0; i < size.length; i++) {
            for (int j = maxSize; j > 0; j--) {
                if (j >= size[i]) {
                    dp[j] = Math.max(dp[j], dp[j - size[i]] + size[i]);
                }
            }
        }
        return dp[maxSize];
    }

    public int backPackII(int maxSize, int[] size, int[] value) {
        // maximum value of using first i items under total size j
        int[] dp = new int[maxSize + 1];
        for (int i = 0; i < size.length; i++) {
            for (int j = maxSize; j >= size[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - size[i]] + value[i]);
            }
        }
        return dp[maxSize];
    }
}
