package com.github.antonfermat.leetcode.contest.weekly373;

import java.util.*;

public class Solution4 {
    private final Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');

    public long beautifulSubstrings(String s, int k) {
        long res = 0;
        int len = s.length();
        var map = new HashMap<Integer, Map<Pair, Long>>();
        map.put(0, new HashMap<>(Map.of(new Pair(0, 0), 1L)));

        int v = 0, c = 0;
        for (int i = 0; i < len; i++) {
            if (set.contains(s.charAt(i))) v++;
            else c++;
            int diff = v - c;
            var p = new Pair(v % k, c % k);
            var subMap = map.computeIfAbsent(diff, o -> new HashMap<>());
            long x = 0;
            for (var e : subMap.entrySet()) {
                Pair p2 = e.getKey();
                if (((p.v - p2.v) * (p.c - p2.c)) % k == 0) res += e.getValue();
            }
            res += x;
            subMap.put(p, subMap.getOrDefault(p, 0L) + 1);
        }
        return res;
    }

    record Pair(int v, int c) {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return v == pair.v && c == pair.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(v, c);
        }
    }
}
