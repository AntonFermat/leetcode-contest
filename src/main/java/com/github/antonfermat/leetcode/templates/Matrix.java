package com.github.antonfermat.leetcode.templates;

public class Matrix {

    /**
     * clockwise rotate
     *
     */
    private static int[][] rotate(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        var res = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) res[j][m - 1 - i] = grid[i][j];
        }
        return res;
    }
}
