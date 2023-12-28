package com.github.antonfermat.leetcode.contest.weekly377;

import java.util.*;

public class Solution3 {

    private Map<Integer, HashMap<Integer, Integer>> map;
    private final Map<Pair, Integer> memo = new HashMap<>();

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        map = new HashMap<>();
        int len = original.length;
        for (int i = 0; i < len; i++) {
            int o1 = original[i] - 'a';
            int o2 = changed[i] - 'a';
            int c = cost[i];
            var map2 = map.computeIfAbsent(o1, o -> new HashMap<>());
            map2.put(o2, Math.min(map2.getOrDefault(o2, Integer.MAX_VALUE), c));
        }
        long res = 0;
        for (int i = 0; i < source.length(); i++) {
            int from = source.charAt(i) - 'a';
            int to = target.charAt(i) - 'a';
            int dist = shortestPath(from, to);
            if (dist == -1) return -1;
            res += dist;
        }
        return res;

    }

    public int shortestPath(int node1, int node2) {
        Pair pair = new Pair(node1, node2);
        if (memo.containsKey(pair)) return memo.get(pair);
        var pq = new PriorityQueue<int[]>(Comparator.comparingInt(i -> i[0]));
        pq.add(new int[]{0, node1});
        var visited = new HashSet<Integer>();

        while (!pq.isEmpty()) {
            var poll = pq.poll();
            int w = poll[0];
            int cur = poll[1];
            if (cur == node2) {
                memo.put(pair, w);
                return w;
            }

            if (visited.contains(cur)) continue;
            visited.add(cur);

            if (map.containsKey(cur)) {
                for (var nextNode : map.get(cur).entrySet()) {
                    int next = nextNode.getKey();
                    int wnext = nextNode.getValue();
                    pq.add(new int[]{wnext + w, next});
                }
            }
        }
        return -1;
    }

    record Pair(int x, int y) {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
