package com.github.antonfermat.leetcode.contest.weekly370;

public class Solution2 {
    public int findChampion(int n, int[][] edges) {
        var degree = new int[n];
        for (int[] e : edges) degree[e[1]]++;
        int res = -1;
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) {
                if (res != -1) return -1;
                res = i;
            }
        }
        return res;
    }
}
