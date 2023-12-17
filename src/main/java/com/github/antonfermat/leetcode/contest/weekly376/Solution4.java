package com.github.antonfermat.leetcode.contest.weekly376;

import java.util.Arrays;

public class Solution4 {
    public int maxFrequencyScore(int[] nums, long k) {
        Arrays.sort(nums);
        int len = nums.length;
        var prefix = new long[len + 1];
        for (int i = 0; i < len; i++) prefix[i + 1] = prefix[i] + nums[i];
        int l = 1, r = len;
        while (l < r) {
            int m = l + (r - l) / 2;
            boolean check = false;
            for (int i = 0; i < len - m + 1; i++) {
                if ((prefix[i + m] - prefix[i + (m + 1) / 2]) - (prefix[i + m / 2] - prefix[i]) <= k) {
                    check = true;
                    break;
                }
            }
            if (check) l = m;
            else r = m - 1;
        }
        return l;
    }
}
