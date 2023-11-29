package com.github.antonfermat.leetcode.contest.weekly372;

import java.util.*;

public class Solution4 {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int hLen = heights.length;
        int qLen = queries.length;

        var next = new int[hLen];
        Arrays.fill(next, -1);
        var stack = new Stack<Integer>();
        for (int i = 0; i < hLen; i++) {
            while (!stack.isEmpty() && heights[i] > heights[stack.peek()]) {
                next[stack.pop()] = i;
            }
            stack.push(i);
        }

        int[] res = new int[qLen];
        for (int i = 0; i < qLen; i++) {
            int[] query = queries[i];
            int max = Math.max(query[0], query[1]);
            int min = Math.min(query[0], query[1]);

            if (query[0] == query[1] || heights[min] < heights[max]) {
                res[i] = max;
            } else {
                while (next[max] != -1 && heights[next[max]] <= heights[min]) {
                    max = next[max];
                }
                res[i] = next[max];
            }
        }
        return res;
    }
}