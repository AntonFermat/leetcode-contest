package com.github.antonfermat.leetcode.contest.biweekly120;

import java.util.*;

public class Solution3 {
    public long incremovableSubarrayCount(int[] nums) {
        int len = nums.length;
        var left = new TreeMap<Integer, Integer>();
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            if (left.isEmpty() || left.lastKey() < num) left.put(num, i);
            else break;
        }
        var right = new TreeMap<Integer, Integer>();
        for (int i = len - 1; i >= 0; i--) {
            int num = nums[i];
            if (right.isEmpty() || right.firstKey() > num) right.put(num, i);
            else break;
        }
        long res = left.size();
        for (var e : left.entrySet()) {
            int num = e.getKey();
            Integer floor = right.floorKey(num + 1);
            if (floor != null) {
                res += len - right.get(floor);
            }
        }
        return res;
    }
}
