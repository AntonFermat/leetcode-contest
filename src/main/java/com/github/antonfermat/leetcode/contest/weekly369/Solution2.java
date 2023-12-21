package com.github.antonfermat.leetcode.contest.weekly369;

public class Solution2 {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        int zero1 = 0, zero2 = 0;
        for (int num1 : nums1) {
            sum1 += num1;
            if (num1 == 0) zero1++;
        }
        for (int num2 : nums2) {
            sum2 += num2;
            if (num2 == 0) zero2++;
        }
        long max = Math.max(sum1 + zero1, sum2 + zero2);
        if ((zero2 == 0 && sum1 + zero1 > sum2) || (zero1 == 0 && sum2 + zero2 > sum1)) return -1;
        return max;
    }
}
