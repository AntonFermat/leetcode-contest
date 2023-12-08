package com.github.antonfermat.leetcode.contest.weekly371;

public class Solution1 {
    public int maximumStrongPairXor(int[] nums) {
        int res = 0;
        for (int x : nums) {
            for (int y : nums) {
                if (Math.abs(x - y) <= Math.min(x, y)) res = Math.max(res, x ^ y);
            }
        }
        return res;
    }
}
