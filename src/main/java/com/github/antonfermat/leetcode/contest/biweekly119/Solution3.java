package com.github.antonfermat.leetcode.contest.biweekly119;

import java.util.HashMap;

public class Solution3 {
    public int maxSubarrayLength(int[] nums, int k) {
        int res = 0;
        var map = new HashMap<Integer, Integer>();
        for (int r = 0, l = 0; r < nums.length; r++) {
            int numR = nums[r];
            map.put(numR, map.getOrDefault(numR, 0) + 1);
            while (map.get(numR) > k) {
                int numL = nums[l];
                map.put(numL, map.get(numL) - 1);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
