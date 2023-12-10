package com.github.antonfermat.leetcode.contest.biweekly119;

import java.util.Arrays;

public class Solution4 {

    public int numberOfSets(int n, int maxDistance, int[][] roads) {
        var map = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(map[i], 100_000);
        for (int[] r : roads) {
            int n0 = r[0], n1 = r[1], dist = r[2];
            map[n0][n1] = Math.min(map[n0][n1], dist);
            map[n1][n0] = Math.min(map[n1][n0], dist);
        }
        int res = 0;
        for (int i = 0; i < (1 << n); i++) {
            var nmap = new int[n][n];
            for (int j = 0; j < n; j++) nmap[j] = Arrays.copyOf(map[j], n);
            if (getMaxDistance(i, n, nmap) <= maxDistance) res++;
        }
        return res;
    }

    private int getMaxDistance(int mask, int n, int[][] map) {
        int res = 0;
        // Floyd-Warshall
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) > 0) {
                for (int j = 0; j < n; j++) {
                    if (j != i && (mask & (1 << j)) > 0) {
                        for (int k = 0; k < n; k++) {
                            if (k != j && (mask & (1 << k)) > 0) {
                                map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) > 0) {
                for (int j = i + 1; j < n; j++) {
                    if ((mask & (1 << j)) > 0) {
                        res = Math.max(res, map[i][j]);
                    }
                }
            }
        }
        return res;
    }
}
