package com.github.antonfermat.leetcode.contest.weekly375;

public class Solution1 {
    public int countTestedDevices(int[] batteryPercentages) {
        int res = 0;
        for (int bp : batteryPercentages) {
            if (bp - res > 0) res++;
        }
        return res;
    }
}
