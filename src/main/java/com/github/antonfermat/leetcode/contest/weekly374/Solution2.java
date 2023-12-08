package com.github.antonfermat.leetcode.contest.weekly374;

import java.util.*;

public class Solution2 {
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        int res = 0, index = 0;
        long cur = 1;
        while (cur <= target) {
            if (index < coins.length && coins[index] <= cur) {
                cur += coins[index++];
            } else {
                res++;
                cur += cur;
            }
        }
        return res;
    }
}
