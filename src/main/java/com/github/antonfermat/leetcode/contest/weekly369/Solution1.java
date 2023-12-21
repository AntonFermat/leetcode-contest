package com.github.antonfermat.leetcode.contest.weekly369;

public class Solution1 {
    public int findKOr(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int x = 1 << i;
            int count = 0;
            for (int num : nums) {
                if ((num & x) != 0) count++;
            }
            if (count >= k) res += x;
        }
        return res;
    }
}
