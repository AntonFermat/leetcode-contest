package com.github.antonfermat.leetcode.templates;

public class MathA {
    public static double median(int[] arr) {
        int len = arr.length;
        double median = (arr[len / 2] + arr[(len - 1) / 2]) / 2.0;
        return median;
    }

    /**
     * Arithmetic progression
     * [l, r] with step 1
     */
    private static long ap1(long l, long r) {
        return (l + r) * (r - l + 1) / 2;
    }

    /**
     * @param l - from
     * @param r - to
     * @param n - number of steps
     */
    private static long ap(long l, long r, long n) {
        return (l + r) * n / 2;
    }


    private int pow(int a, int b, int mod) {
        return java.math.BigInteger.valueOf(a).modPow(java.math.BigInteger.valueOf(b), java.math.BigInteger.valueOf(mod)).intValue();
    }
}
