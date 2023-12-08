package com.github.antonfermat.leetcode.contest.weekly371;

public class Solution3 {
    public int minOperations(int[] nums1, int[] nums2) {
        int res = helper(nums1, nums2);
        int len = nums1.length;
        int tmp = nums1[len - 1];
        nums1[len - 1] = nums2[len - 1];
        nums2[len - 1] = tmp;
        return Math.min(res, 1 + helper(nums1, nums2));
    }

    public int helper(int[] nums1, int[] nums2) {
        int len = nums1.length;
        int res = 0;
        int max1 = nums1[len - 1], max2 = nums2[len - 1];
        int max = Math.max(max1, max2);
        int min = Math.min(max1, max2);
        for (int i = 0; i < len - 1; i++) {
            int num1 = nums1[i], num2 = nums2[i];
            if (Math.max(num1, num2) > max || Math.min(num1, num2) > min) return -1;
            if (num1 > max1 || num2 > max2) res++;
        }
        return res;
    }
}
