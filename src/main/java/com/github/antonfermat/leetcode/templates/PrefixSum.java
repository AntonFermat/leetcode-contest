package com.github.antonfermat.leetcode.templates;

public class PrefixSum {
    public int[] fn(int[] arr) {
        int len = arr.length;
        int[] prefix = new int[len + 1];
        for (int i = 0; i < len; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }
        return prefix;
    }

    public int[] fn1(int[] arr) {
        int len = arr.length;
        int[] prefix = new int[len];
        prefix[0] = arr[0];
        for (int i = 1; i < len; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        return prefix;
    }
}
