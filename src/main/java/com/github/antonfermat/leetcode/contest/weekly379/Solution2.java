package com.github.antonfermat.leetcode.contest.weekly379;

public class Solution2 {
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        var dir1 = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int[] d1 : dir1) {
            for (int i = 1; i < 8; i++) {
                int a1 = a + d1[0] * i;
                int b1 = b + d1[1] * i;
                if (a1 == c && b1 == d) break;
                if (a1 == e && b1 == f) return 1;
            }
        }
        var dir2 = new int[][]{{1, 1}, {-1, -1}, {-1, 1}, {1, -1}};
        for (int[] d2 : dir2) {
            for (int i = 1; i < 8; i++) {
                int c1 = c + d2[0] * i;
                int d1 = d + d2[1] * i;
                if (c1 == a && d1 == b) break;
                if (c1 == e && d1 == f) return 1;
            }
        }
        return 2;
    }
}
