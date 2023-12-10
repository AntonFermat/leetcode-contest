package com.github.antonfermat.leetcode.contest.weekly375;

public class Solution3 {
    public long countSubarrays(int[] nums, int k) {
        int max = nums[0];
        for (int num : nums) max = Math.max(max, num);
        long res = 0;
        int count = 0;
        for (int r = 0, l = 0; r < nums.length; r++) {
            if (nums[r] == max) count++;
            while (nums[l] != max || count > k) {
                if (nums[l] == max) count--;
                l++;
            }
            if (count == k) res += (l + 1);
        }
        return res;
    }
}
