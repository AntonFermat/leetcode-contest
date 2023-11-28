package com.github.antonfermat.leetcode.contest.biweekly118;

import java.util.*;

public class Solution1 {
    public List<Integer> findWordsContaining(String[] words, char x) {
        var res = new ArrayList<Integer>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) != -1) res.add(i);
        }
        return res;
    }
}
