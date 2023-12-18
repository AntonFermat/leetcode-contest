package com.github.antonfermat.leetcode.contest.weekly374;

public class Solution3 {
    public int countCompleteSubstrings(String word, int k) {
        int res = 0;
        int len = word.length();
        var sb = new StringBuilder();
        for (int l = 0; l < len; l++) {
            int r = l + 1;
            sb.append(word.charAt(l));
            while (r < len && Math.abs(word.charAt(r) - word.charAt(r - 1)) <= 2) {
                sb.append(word.charAt(r));
                r++;
            }
            if (!sb.isEmpty()) {
                res += helper(sb.toString(), k);
            }
            sb = new StringBuilder();
            l = r - 1;
        }
        return res;
    }

    private int helper(String word, int k) {
        int res = 0;
        int len = word.length();
        for (int j = 1; j <= 26; j++) {
            int sLen = k * j;
            var freq = new int[26];
            if (sLen > len) break;
            for (int i = 0; i < sLen; i++) freq[word.charAt(i) - 'a']++;
            if (check(freq, j, k)) res++;
            for (int i = sLen; i < len; i++) {
                var next = word.charAt(i);
                freq[next - 'a']++;
                var prev = word.charAt(i - sLen);
                freq[prev - 'a']--;
                if (check(freq, j, k)) res++;
            }
        }
        return res;
    }

    private boolean check(int[] freq, int j, int k) {
        int count = 0;
        for (int value : freq) {
            if (value == 0) continue;
            if (value != k) return false;
            else {
                count++;
                if (count > j) return false;
            }
        }
        return true;
    }
}
