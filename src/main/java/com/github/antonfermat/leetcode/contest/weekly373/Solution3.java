package com.github.antonfermat.leetcode.contest.weekly373;

import java.util.*;

public class Solution3 {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int len = nums.length;
        var res = new int[len];
        var arr = new int[len][2];
        for (int i = 0; i < len; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
            res[i] = nums[i];
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        int prev = arr[0][0];
        var val = new ArrayList<>(List.of(arr[0][0]));
        var indexes = new ArrayList<>(List.of(arr[0][1]));

        for (int i = 1; i < len; i++) {
            if (arr[i][0] - prev <= limit) {
                indexes.add(arr[i][1]);
                val.add(arr[i][0]);
            }
            if (arr[i][0] - prev > limit || i == len - 1) {
                Collections.sort(indexes);
                for (int j = 0; j < indexes.size(); j++) res[indexes.get(j)] = val.get(j);
                indexes = new ArrayList<>(List.of(arr[i][1]));
                val = new ArrayList<>(List.of(arr[i][0]));
            }
            prev = arr[i][0];
        }
        return res;
    }
}
