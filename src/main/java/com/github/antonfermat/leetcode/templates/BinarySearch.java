package com.github.antonfermat.leetcode.templates;

public class BinarySearch {

    // Necessary values are right
    private int right() {
        int l = 0, r = Integer.MAX_VALUE;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (check(m)) r = m;
            else l = m + 1;
        }
        return r;
    }

    // Necessary values are left
    private int left() {
        int l = 0, r = Integer.MAX_VALUE;
        while (l < r) {
            int m = r - (r - l) / 2;
            if (check(m)) l = m;
            else r = m - 1;
        }
        return l;
    }

    private boolean check(int m) {
        return true;
    }

}
