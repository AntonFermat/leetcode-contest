package com.github.antonfermat.leetcode.contest.biweekly119;

public class Solution2 {
    public int removeAlmostEqualCharacters(String word) {
        int res = 0, cur = 1;
        for (int i = 0; i < word.length() - 1; i++) {
            if (Math.abs(word.charAt(i) - word.charAt(i + 1)) <= 1) cur++;
            else {
                res += cur / 2;
                cur = 1;
            }
        }
        return res + cur / 2;
    }
}
