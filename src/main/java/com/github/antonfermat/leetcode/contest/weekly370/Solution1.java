package com.github.antonfermat.leetcode.contest.weekly370;

public class Solution1 {
    public int findChampion(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid[0].length; i++) {
            if (grid[res][i] == 0) res = i;
        }
        return res;
    }
}
