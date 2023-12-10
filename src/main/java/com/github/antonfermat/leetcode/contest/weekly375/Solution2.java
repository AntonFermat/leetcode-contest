package com.github.antonfermat.leetcode.contest.weekly375;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        var res = new ArrayList<Integer>();
        for (int i = 0; i < variables.length; i++) {
            var v = variables[i];
            int a = v[0], b = v[1], c = v[2], m = v[3];
            int x = 1;
            for (int j = 0; j < b; j++) x = (x * a) % 10;
            int y = 1;
            for (int j = 0; j < c; j++) y = (y * x) % m;
            if (y == target) res.add(i);
        }
        return res;
    }
}
