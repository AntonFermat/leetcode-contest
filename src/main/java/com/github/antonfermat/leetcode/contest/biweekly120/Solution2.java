package com.github.antonfermat.leetcode.contest.biweekly120;

import java.util.*;

public class Solution2 {

    public long largestPerimeter(int[] nums) {
        long sum = 0;
        Arrays.sort(nums);
        for (int num : nums) sum += num;

        for (int i = nums.length - 1; i >= 2; i--) {
            if (sum - nums[i] > nums[i]) return sum;
            sum -= nums[i];
        }
        return -1;
    }

}
