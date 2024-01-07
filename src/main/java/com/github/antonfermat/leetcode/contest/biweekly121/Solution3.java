package com.github.antonfermat.leetcode.contest.biweekly121;

import java.util.*;

public class Solution3 {

    private final Map<Integer, Integer> dp = new HashMap<>();

    public int minimumOperationsToMakeEqual(int x, int y) {
        if (x <= y) return y - x;
        if (dp.containsKey(x)) return dp.get(x);
        int res = Math.abs(x - y);
        res = Math.min(res, 1 + x % 11 + minimumOperationsToMakeEqual(x / 11, y));
        res = Math.min(res, 1 + (11 - x % 11) + minimumOperationsToMakeEqual(x / 11 + 1, y));
        res = Math.min(res, 1 + x % 5 + minimumOperationsToMakeEqual(x / 5, y));
        res = Math.min(res, 1 + (5 - x % 5) + minimumOperationsToMakeEqual(x / 5 + 1, y));
        dp.put(x, res);
        return res;
    }
}
