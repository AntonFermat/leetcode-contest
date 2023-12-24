package com.github.antonfermat.leetcode.contest.biweekly120;

public class Solution1 {

    public int incremovableSubarrayCount(int[] nums) {
        int len = nums.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            boolean[] arr = new boolean[len];
            for (int j = i; j < len; j++) {
                arr[i] = true;
                if (isStrictlyIncreasing(nums, arr)) res++;
            }
        }
        return res;
    }

    private boolean isStrictlyIncreasing(int[] nums, boolean[] arr) {
        int prev = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!arr[i]) {
                if (prev < nums[i]) prev = nums[i];
                else return false;
            }
        }
        return prev != 0;
    }
}