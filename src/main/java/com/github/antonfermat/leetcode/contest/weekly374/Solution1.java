package com.github.antonfermat.leetcode.contest.weekly374;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public List<Integer> findPeaks(int[] mountain) {
        var res = new ArrayList<Integer>();
        for (int i = 1; i < mountain.length - 1; i++) {
            int m = mountain[i];
            if (m > mountain[i - 1] && m > mountain[i + 1]) res.add(i);
        }
        return res;
    }
}
