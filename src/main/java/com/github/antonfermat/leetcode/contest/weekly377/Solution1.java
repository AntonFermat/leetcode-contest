package com.github.antonfermat.leetcode.contest.weekly377;

import java.util.*;

public class Solution1 {
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        var res = new int[nums.length];
        for (int i = 0; i < nums.length; i += 2) {
            res[i] = nums[i + 1];
            res[i + 1] = nums[i];
        }
        return res;
    }

}
