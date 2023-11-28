package com.github.antonfermat.leetcode.templates;

import java.util.*;

public class Binary {

    public static void main(String[] args) {
        int x = -44434;

        // Swap in memory
        int swap1 = 12, swap2 = 34;
        swap1 = swap1 ^ swap2;
        swap2 = swap2 ^ swap1;
        swap1 = swap1 ^ swap2;

        // if 'x = n ^ 2' -> 'x & (x - 1) == 0', remove the most right 1
        // ex, 10000 -> 0 or 1010 -> 1000
        int a = x & (x - 1);
        //find the most right 1, ex. 10001100 -> 100
        int b = x & (-x);
        //find the most right 1
        int c = x ^ (x & (x - 1));

        {
            int[] nums = {1, 2, 3};
            int or = 0, xor = 0;
            for (int i = 0; i < nums.length; i++) {
                or |= nums[i];
                xor ^= nums[i];
            }

            if ((or & (xor ^ 3)) == (1 | 2)) {
                System.out.println("OK");
            }
        }
    }

    private static List<Integer> grayCode(int n) {
        var res = new ArrayList<Integer>();
        int size = 1 << n;
        for (int i = 0; i < size; i++) {
            res.add(i ^ (i >> 1));
        }
        return res;
    }

}
