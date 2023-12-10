package com.github.antonfermat.leetcode.contest.weekly375;

import java.util.HashMap;

public class Solution4 {
    public int numberOfGoodPartitions(int[] nums) {
        var rightMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) rightMap.put(nums[i], i);
        int count = 0;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int rightIndex = rightMap.get(num);
            maxIndex = Math.max(maxIndex, rightIndex);
            if (rightIndex == i && maxIndex == rightIndex) count++;
        }
        int mod = 1_000_000_007;
        long res = 1;
        for (int i = 1; i < count; i++) {
            res = (res * 2) % mod;
        }
        return (int) res;
    }
}
