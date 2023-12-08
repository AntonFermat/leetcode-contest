package com.github.antonfermat.leetcode.contest.weekly371;

import java.util.*;

public class Solution4 {
    public int maximumStrongPairXor(int[] nums) {
        int res = 0;
        for (int i = 20; i >= 0; i--) {
            res <<= 1;
            var minMap = new HashMap<Integer, Integer>();
            var maxMap = new HashMap<Integer, Integer>();
            for (int num : nums) {
                int p = num >> i;
                if (!minMap.containsKey(p)) {
                    minMap.put(p, num);
                    maxMap.put(p, num);
                }
                minMap.put(p, Math.min(minMap.get(p), num));
                maxMap.put(p, Math.max(maxMap.get(p), num));
            }
            for (int x : minMap.keySet()) {
                int y = res ^ 1 ^ x;
                if (x >= y && minMap.containsKey(y) && minMap.get(x) <= maxMap.get(y) * 2) {
                    res |= 1;
                    break;
                }
            }
        }
        return res;
    }
}
