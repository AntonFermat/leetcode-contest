package com.github.antonfermat.leetcode.contest.weekly378;

import java.util.*;

public class Solution2_3 {
    public int maximumLength(String s) {
        var map = new HashMap<Integer, List<Integer>>();
        int cur = 1;
        int prev = s.charAt(0) - 'a';
        for (int i = 1; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (c != prev) {
                map.computeIfAbsent(prev, o -> new ArrayList<>()).add(cur);
                prev = c;
                cur = 0;
            }
            cur++;
            if (i == s.length() - 1) {
                map.computeIfAbsent(prev, o -> new ArrayList<>()).add(cur);
            }
        }
        int res = -1;
        for (var e : map.entrySet()) {
            var list = e.getValue();
            Collections.sort(list);
            for (int i = 0; i < list.size(); i++) {
                int x = list.get(i);
                if (list.size() - i > 2) {
                    res = Math.max(res, Math.max(x, -1));
                } else if (list.size() - i > 1) {
                    res = Math.max(res, Math.max(x - 1, -1));
                    if (x < list.get(i + 1)) {
                        res = Math.max(res, Math.max(x, -1));
                    }
                } else {
                    res = Math.max(res, Math.max(x - 2, -1));
                }
            }
        }
        return res == 0 ? -1 : res;
    }
}
