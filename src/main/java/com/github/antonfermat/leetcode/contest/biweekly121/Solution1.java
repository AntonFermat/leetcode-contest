package com.github.antonfermat.leetcode.contest.biweekly121;

import java.util.*;

public class Solution1 {
    public int missingInteger(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) break;
            res += nums[i];
        }
        Arrays.sort(nums);
        for (int num : nums) {
            if (res == num) {
                res++;
            }
        }
        return res;
    }
}
