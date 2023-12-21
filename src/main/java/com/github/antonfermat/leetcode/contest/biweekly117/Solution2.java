package com.github.antonfermat.leetcode.contest.biweekly117;

public class Solution2 {
    public long distributeCandies(int n, int limit) {
        long res = 0;
        for (int i = Math.max(0, n - 2 * limit); i <= Math.min(limit, n); i++) {
            // i - candies for first child, so add possible ways to give candies to second child`
            res += Math.min(limit, n - i) - Math.max(0, (n - i) - limit) + 1;
        }
        return res;
    }
}
