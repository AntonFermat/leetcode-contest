package com.github.antonfermat.leetcode.contest.weekly373;

public class Solution1 {
    public boolean areSimilar(int[][] mat, int k) {
        int n = mat[0].length;
        for (int[] row : mat) {
            for (int j = 0; j < n; j++) {
                if (row[j] != row[(j + k) % n]) return false;
            }
        }
        return true;
    }
}