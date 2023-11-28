package com.github.antonfermat.leetcode.contest.biweekly118;

public class Solution4 {
    public int findMaximumLength(int[] nums) {
        int len = nums.length;
        long[] prefix = new long[len + 1];
        for (int i = 0; i < len; i++) prefix[i + 1] = prefix[i] + nums[i];
        int[] dp = new int[len + 1];
        int[] indexes = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            indexes[i] = Math.max(indexes[i], indexes[i - 1]);
            dp[i] = dp[indexes[i]] + 1;
            int l = i, r = len, index = 0;
            long next = prefix[i] - prefix[indexes[i]];
            while (l < r) {
                int m = r - (r - l) / 2;
                if (prefix[m] - prefix[i] < next) {
                    l = m;
                } else {
                    index = m;
                    r = m - 1;
                }
            }
            indexes[index] = i;
        }
        return dp[len];
    }
}
