package com.github.antonfermat.leetcode.contest.biweekly118;

public class Solution3 {
    public int minimumCoins(int[] prices) {
        return helper(prices, 0, new int[prices.length]);
    }

    private int helper(int[] prices, int index, int[] dp) {
        if (index >= prices.length) return 0;
        if (dp[index] != 0) return dp[index];
        int res = prices[index] + helper(prices, index + 1, dp);
        for (int i = index + 1; i <= 2 * index + 2; i++) {
            res = Math.min(res, prices[index] + helper(prices, i, dp));
        }
        return dp[index] = res;
    }
}
