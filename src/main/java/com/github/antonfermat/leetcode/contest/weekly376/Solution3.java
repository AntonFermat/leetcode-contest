package com.github.antonfermat.leetcode.contest.weekly376;

import java.util.Arrays;

class Solution3 {
    public long minimumCost(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        var median = len % 2 == 1 ? nums[len / 2] : (nums[len / 2] + nums[len / 2 - 1]) / 2;
        long leftRes = minimumCost(median, nums, -1);
        long rightRes = minimumCost(median, nums, 1);
        return Math.min(leftRes, rightRes);
    }

    private long minimumCost(int val, int[] nums, int step) {
        while (!isPal(val)) val += step;
        long res = 0;
        for (int num : nums) res += Math.abs(num - val);
        return res;
    }

    private boolean isPal(int res) {
        var cc = String.valueOf(res).toCharArray();
        for (int i = 0; i < cc.length / 2; i++) {
            if (cc[i] != cc[cc.length - 1 - i]) return false;
        }
        return true;
    }
}