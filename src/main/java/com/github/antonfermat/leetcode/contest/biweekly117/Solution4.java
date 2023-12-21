package com.github.antonfermat.leetcode.contest.biweekly117;

import java.util.*;

public class Solution4 {
    public long maxSpending(int[][] values) {
        var list = new ArrayList<Integer>();
        for (int[] value : values) {
            for (int i : value) list.add(i);
        }
        Collections.sort(list);
        long count = 1, res = 0;
        for (int val : list) res += val * count++;
        return res;
    }
}
