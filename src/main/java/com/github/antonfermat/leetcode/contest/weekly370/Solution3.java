package com.github.antonfermat.leetcode.contest.weekly370;

import java.util.*;

public class Solution3 {
    private final Map<Integer, Set<Integer>> map = new HashMap<>();
    private int[] values;
    private final Set<Integer> visited = new HashSet<>();

    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        this.values = values;
        for (int[] e : edges) {
            map.computeIfAbsent(e[0], o -> new HashSet<>()).add(e[1]);
            map.computeIfAbsent(e[1], o -> new HashSet<>()).add(e[0]);
        }
        long sum = 0;
        var q = new LinkedList<>(List.of(0));
        var v = new HashSet<>(List.of(0));
        while (!q.isEmpty()) {
            int cur = q.poll();
            sum += values[cur];
            if (map.containsKey(cur)) {
                for (int next : map.get(cur)) {
                    if (v.contains(next)) continue;
                    q.add(next);
                    v.add(next);
                }
            }
        }

        visited.add(0);
        long min = dfs(0);
        return sum - min;
    }


    private long dfs(int cur) {
        long min = values[cur];
        long sum = 0;
        if (map.containsKey(cur)) {
            for (int next : map.get(cur)) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    sum += dfs(next);
                }
            }
        }
        return sum == 0 ? min : Math.min(min, sum);
    }
}
