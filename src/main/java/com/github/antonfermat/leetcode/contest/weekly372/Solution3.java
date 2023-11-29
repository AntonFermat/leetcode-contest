package com.github.antonfermat.leetcode.contest.weekly372;

import java.math.BigInteger;

class Solution3 {
    public int maximumXorProduct(long a, long b, int n) {
        var bigA = BigInteger.valueOf(a);
        var bigB = BigInteger.valueOf(b);
        var bigX = BigInteger.ZERO;
        var res = bigA.xor(bigX).multiply(bigB.xor(bigX));
        for (int i = 0; i < n; i++) {
            var temp = bigX.or(BigInteger.valueOf(1L << i));
            BigInteger val = bigA.xor(temp).multiply(bigB.xor(temp));
            if (val.compareTo(res) > 0) {
                bigX = temp;
                res = val;
            }
        }
        return res.mod(BigInteger.valueOf(1_000_000_007)).intValue();
    }
}