package com.github.antonfermat.leetcode.templates;

import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings("Duplicates")
public class Primes {

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static int gcd2(int a, int b) {
        while (a % b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return b;
    }

    private static int smallestDivisible(int a, int b) {
        int a1 = a, b1 = b;
        while (a1 % b1 != 0) {
            int tmp = a1 % b1;
            a1 = b1;
            b1 = tmp;
        }
        return a * b / b1;
    }

    public static List<Integer> findPrimes(int n) {
        var prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        for (int i = 2; i <= n; i++) {
            if (prime[i] && (long) i * i <= (long) n) {
                for (int j = i * i; j <= n; j += i) prime[j] = false;
            }
        }
        var res = new ArrayList<Integer>();
        for (int i = 2; i <= n; i++) {
            if (prime[i]) res.add(i);
        }
        return res;
    }

    private static Set<Integer> primeDivisorsSet(int num) {
        var res = new HashSet<Integer>();
        while (num % 2 == 0) {
            res.add(2);
            num /= 2;
        }
        int factor = 3;
        while (factor <= (int) Math.sqrt(num)) {
            if (num % factor == 0) {
                res.add(factor);
                num /= factor;
            } else factor += 2;
        }
        if (num != 1) res.add(num);
        return res;
    }

    private static List<Integer> primeDivisorsList(int num) {
        var res = new ArrayList<Integer>();
        while (num % 2 == 0) {
            res.add(2);
            num /= 2;
        }
        int factor = 3;
        while (factor <= (int) Math.sqrt(num)) {
            if (num % factor == 0) {
                res.add(factor);
                num /= factor;
            } else factor += 2;
        }
        if (num != 1) res.add(num);
        return res;
    }

    /**
     * TODO check it
     *
     */
    private static Map<Integer, Integer> primeDivisorsMap(int num) {
        var res = new HashMap<Integer, Integer>();
        while (num % 2 == 0) {
            res.put(2, res.getOrDefault(2, 0) + 1);
            num /= 2;
        }
        int factor = 3;
        while (factor <= (int) Math.sqrt(num)) {
            if (num % factor == 0) {
                res.put(factor, res.getOrDefault(factor, 0) + 1);
                num /= factor;
            } else factor += 2;
        }
        if (num != 1) res.put(num, res.getOrDefault(num, 0) + 1);
        return res;
    }

    /**
     * Euler's totient function
     *
     */
    public static int phi(int n) {
        int result = n;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                while (n % i == 0) n /= i;
                result -= result / i;
            }
        }
        if (n > 1) result -= result / n;
        return result;
    }

    /**
     * Math.sqrt(100_000)
     */
    int[] primes100_000 = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47,
            53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131,
            137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223,
            227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313};
}
