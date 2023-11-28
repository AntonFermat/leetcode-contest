package com.github.antonfermat.leetcode.templates.tree;

public class SegmentTree {

    private final int[] tree;
    private final int[] arr;

    public SegmentTree(int[] nums) {
        arr = nums;
        tree = new int[4 * nums.length];
        buildTree(0, nums.length - 1, 0);
    }

    private void buildTree(int start, int end, int index) {
        if (start == end) {
            tree[index] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        buildTree(start, mid, 2 * index + 1);
        buildTree(mid + 1, end, 2 * index + 2);
        tree[index] = tree[2 * index + 1] + tree[2 * index + 2];
    }

    public void update(int index, int val) {
        updateHelper(0, arr.length - 1, index, val, 0);
    }

    private void updateHelper(int start, int end, int index, int val, int node) {
        if (start == end) {
            tree[node] = val;
            arr[index] = val;
            return;
        }
        int mid = (start + end) / 2;
        if (index <= mid) {
            updateHelper(start, mid, index, val, 2 * node + 1);
        } else {
            updateHelper(mid + 1, end, index, val, 2 * node + 2);
        }
        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    public int query(int left, int right) {
        return queryHelper(0, arr.length - 1, left, right, 0);
    }

    private int queryHelper(int start, int end, int left, int right, int node) {
        if (right < start || left > end) {
            return 0;
        }
        if (left <= start && right >= end) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        int leftSum = queryHelper(start, mid, left, right, 2 * node + 1);
        int rightSum = queryHelper(mid + 1, end, left, right, 2 * node + 2);
        return leftSum + rightSum;
    }
}