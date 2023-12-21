package com.github.antonfermat.leetcode.contest.weekly369;

import java.util.Arrays;

public class Solution3 {
    public long minIncrementOperations(int[] nums, int k) {
        int len = nums.length;
        var dp = new long[len];
        Arrays.fill(dp, Long.MAX_VALUE);
        for (int i = 0; i < 3; i++) dp[i] = Math.max(0, k - nums[i]);

        for (int i = 3; i < len; i++) {
            long diff = Math.max(0, k - nums[i]);
            for (int j = 0; j < 3; j++) {
                dp[i] = Math.min(dp[i], dp[i - j - 1] + diff);
            }
        }

        long res = Long.MAX_VALUE;
        for (int i = 0; i < 3; i++) res = Math.min(res, dp[len - 1 - i]);
        return res;
    }
}
