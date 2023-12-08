package com.github.antonfermat.leetcode.contest.weekly371;

import java.util.*;

public class Solution2 {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        var map = new HashMap<String, List<Integer>>();
        for (List<String> at : access_times) {
            String a = at.get(0);
            String t = at.get(1);
            int time = ((t.charAt(0) - '0') * 10 + (t.charAt(1) - '0')) * 60
                    + (t.charAt(2) - '0') * 10 + (t.charAt(3) - '0');
            map.computeIfAbsent(a, o -> new ArrayList<>()).add(time);
        }
        var res = new ArrayList<String>();
        for (var e : map.entrySet()) {
            var times = e.getValue();
            Collections.sort(times);
            if (times.size() > 2) {
                for (int i = 0; i < times.size() - 2; i++) {
                    if (times.get(i + 2) - times.get(i) < 60) {
                        res.add(e.getKey());
                        break;
                    }
                }
            }
        }
        return res;
    }
}
