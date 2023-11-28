package com.github.antonfermat.leetcode.templates.tree;

public class FenwickTree {
    public static void main(String[] args) {
        FenwickTree ft = new FenwickTree(5);
        ft.update(1, 5);
        ft.update(2, 3);
        ft.update(3, 7);
        System.out.println(ft.rangeSum(1, 3));
    }

    private final int[] tree;

    public FenwickTree(int size) {
        tree = new int[size];
    }

    public void update(int index, int delta) {
        while (index < tree.length) {
            tree[index] += delta;
            index += (index & -index);
        }
    }

    public int prefixSum(int index) {
        int sum = 0;
        while (index > 0) {
            sum += tree[index];
            index -= (index & -index);
        }
        return sum;
    }

    public int rangeSum(int start, int end) {
        return prefixSum(end) - prefixSum(start - 1);
    }
}
