package com.github.antonfermat.leetcode.contest.weekly373;

import java.util.*;

public class Solution2 {
    private final Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');

    public int beautifulSubstrings(String s, int k) {
        int len = s.length();
        int res = 0;
        for (int i = 0; i < len; i++) {
            int v = 0;
            for (int j = i; j < len; j++) {
                char c = s.charAt(j);
                if (set.contains(c)) v++;
                int sLen = j - i + 1;
                if (sLen - v == v && ((sLen - v) * v) % k == 0) res++;
            }
        }
        return res;
    }
}
