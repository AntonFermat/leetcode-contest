package com.github.antonfermat.leetcode.contest.weekly369;

import java.util.*;

class Solution4 {
    private Map<Integer, Set<Integer>> map;
    private int[] coins;
    private int k;
    private int[][] dp;

    public int maximumPoints(int[][] edges, int[] coins, int k) {
        this.map = new HashMap<>();
        this.coins = coins;
        this.k = k;
        this.dp = new int[14][coins.length];
        for (int i = 0; i < 14; i++) Arrays.fill(dp[i], Integer.MIN_VALUE);
        for (int[] e : edges) {
            map.computeIfAbsent(e[0], o -> new HashSet<>()).add(e[1]);
            map.computeIfAbsent(e[1], o -> new HashSet<>()).add(e[0]);
        }
        // Remove extra child -> parent edges
        dfs(0);
        return dfs2(0, 0);
    }

    private int dfs2(int shift, int node) {
        int val = coins[node] >> shift;
        if (shift > 13) return 0;
        if (dp[shift][node] != Integer.MIN_VALUE) return dp[shift][node];
        int res1 = val - k;
        int res2 = val / 2;
        if (map.containsKey(node)) {
            for (int next : map.get(node)) {
                res1 += dfs2(shift, next);
                res2 += dfs2(shift + 1, next);
            }
        }
        return dp[shift][node] = Math.max(res1, res2);
    }

    void dfs(int parent) {
        if (map.containsKey(parent)) {
            for (int next : map.get(parent)) {
                map.get(next).remove(parent);
                dfs(next);
            }
        }
    }
}