package com.github.antonfermat.leetcode.contest.weekly372;

public class Solution1 {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
        for (int i = Math.min(l1, Math.min(l2, l3)); i >= 1; i--) {
            var sub = s1.substring(0, i);
            if (s1.startsWith(sub) && s2.startsWith(sub) && s3.startsWith(sub))
                return l1 + l2 + l3 - 3 * i;
        }
        return -1;
    }
}