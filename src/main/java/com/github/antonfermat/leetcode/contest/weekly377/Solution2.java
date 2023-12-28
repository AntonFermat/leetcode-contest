package com.github.antonfermat.leetcode.contest.weekly377;

import java.util.*;

public class Solution2 {

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        var set = new HashSet<Integer>();
        var hList = new ArrayList<>(List.of(1, m));
        for (int hFence : hFences) hList.add(hFence);
        Collections.sort(hList);
        for (int i = 0; i < hList.size(); i++) {
            for (int j = i + 1; j < hList.size(); j++) {
                set.add(hList.get(j) - hList.get(i));
            }
        }
        var vList = new ArrayList<>(List.of(1, n));
        for (int vFence : vFences) vList.add(vFence);
        Collections.sort(vList);
        long res = 0;
        for (int i = 0; i < vList.size(); i++) {
            for (int j = i + 1; j < vList.size(); j++) {
                int v = vList.get(j) - vList.get(i);
                if (set.contains(v)) res = Math.max(res, (long) v * v);
            }
        }
        return (int) (res == 0 ? -1 : res % 1_000_000_007);
    }
}
