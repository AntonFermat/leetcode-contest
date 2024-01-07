package com.github.antonfermat.leetcode.contest.biweekly121;

public class Solution2 {

    public int minOperations(int[] nums, int k) {
        for (int num : nums) k = k ^ num;
        return Integer.bitCount(k);
    }

    public int minOperations1(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < 21; i++) {
            int b = (k >> i) & 1;
            int sum = 0;
            for (int num : nums) sum += ((num >> i) & 1);
            if (b == 0 && sum % 2 == 1 || b == 1 && sum % 2 == 0) res++;
        }
        return res;
    }
}
