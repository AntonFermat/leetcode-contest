package com.github.antonfermat.leetcode.contest.biweekly118;

import java.util.*;

public class Solution2 {

    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int h = Math.min(max(hBars) + 1, max(vBars) + 1);
        return h * h;
    }

    private int max(int[] bars) {
        Arrays.sort(bars);
        int res = 1;
        int cur = 1;
        int prev = bars[0];
        for (int bar : bars) {
            if (bar == prev + 1) cur++;
            else cur = 1;
            prev = bar;
            res = Math.max(res, cur);
        }
        return res;
    }
}
