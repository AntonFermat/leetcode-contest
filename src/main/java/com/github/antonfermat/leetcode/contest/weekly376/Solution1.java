package com.github.antonfermat.leetcode.contest.weekly376;

import java.util.HashSet;

public class Solution1 {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        var res = new int[2];
        var set = new HashSet<>();
        for (var row : grid) {
            for (var num : row) {
                if (!set.add(num)) res[0] = num;
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count++;
                if (!set.contains(count)) res[1] = count;
            }
        }
        return res;
    }
}
