package com.github.antonfermat.leetcode.contest.weekly372;

import java.util.LinkedList;

public class Solution2 {
    public long minimumSteps(String s) {
        long res = 0;
        var q = new LinkedList<Integer>();
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - '0';
            if (c == 1) q.add(i);
            else if (!q.isEmpty()) {
                res += (i - q.pollFirst());
                q.add(i);
            }
        }
        return res;
    }
}