package com.github.antonfermat.leetcode.contest.biweekly120;

import java.util.*;

public class Solution4 {
    private Map<Integer, Set<Integer>> map;
    private long[] res;
    private int[] cost;
    private final Set<Integer> visited = new HashSet<>();

    public long[] placedCoins(int[][] edges, int[] cost) {
        this.cost = cost;
        int len = edges.length + 1;
        map = new HashMap<>();
        res = new long[len];
        for (var e : edges) {
            map.computeIfAbsent(e[0], o -> new HashSet<>()).add(e[1]);
            map.computeIfAbsent(e[1], o -> new HashSet<>()).add(e[0]);
        }
        dfs(0);
        return res;
    }

    private Set<Integer> dfs(int node) {
        visited.add(node);
        var list = new ArrayList<Integer>();
        list.add(node);
        if (map.containsKey(node)) {
            for (int next : map.get(node)) {
                if (visited.contains(next)) continue;
                list.addAll(dfs(next));
            }
        }
        if (list.size() >= 3) {
            list.sort((o1, o2) -> cost[o1] - cost[o2]);
            int size = list.size();
            res[node] = Math.max(0L, (long) cost[list.get(size - 1)] * cost[list.get(size - 2)] * cost[list.get(size - 3)]);
            res[node] = Math.max(res[node], (long) cost[list.get(0)] * cost[list.get(1)] * cost[list.get(size - 1)]);
        } else {
            res[node] = 1;
        }
        int size = list.size();
        return size >= 3 ? new HashSet<>(List.of(list.get(0), list.get(1), list.get(size - 1), list.get(size - 2), list.get(size - 3))) : new HashSet<>(list);
    }
}