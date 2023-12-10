package com.github.antonfermat.leetcode.contest.biweekly119;

import java.util.HashSet;

public class Solution1 {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        var set1 = new HashSet<Integer>();
        var set2 = new HashSet<Integer>();
        for (int i : nums1) set1.add(i);
        for (int i : nums2) set2.add(i);
        var res = new int[2];
        for (int i : nums1) if (set2.contains(i)) res[0]++;
        for (int i : nums2) if (set1.contains(i)) res[1]++;
        return res;
    }
}
