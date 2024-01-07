package com.github.antonfermat.leetcode.contest.weekly379;

public class Solution1 {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int res = 0;
        int diag = 0;
        for (int[] d : dimensions) {
            int cur = d[0] * d[0] + d[1] * d[1];
            if (cur > diag) {
                diag = cur;
                res = d[0] * d[1];
            } else if (cur == diag) {
                res = Math.max(res, d[0] * d[1]);
            }
        }
        return res;
    }
}
