package com.github.antonfermat.leetcode.contest.weekly378;

public class Solution1 {
    public boolean hasTrailingZeros(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if ((num & 1) == 0) {
                if (++count > 1) return true;
            }
        }
        return false;
    }
}
