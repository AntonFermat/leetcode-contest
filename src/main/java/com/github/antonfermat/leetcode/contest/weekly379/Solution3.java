package com.github.antonfermat.leetcode.contest.weekly379;

import java.util.*;

public class Solution3 {

    public int maximumSetSize(int[] nums1, int[] nums2) {
        int len = nums1.length;
        var set1 = new HashSet<Integer>();
        for (int num : nums1) set1.add(num);
        var set2 = new HashSet<Integer>();
        for (int num : nums2) set2.add(num);
        var common = new HashSet<>(set1);
        common.retainAll(set2);
        int len1 = set1.size();
        int len2 = set2.size();
        int lenC = common.size();
        return Math.min(len, Math.min(len1 - lenC, len / 2) + Math.min(len2 - lenC, len / 2) + lenC);
    }
}
