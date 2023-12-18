package com.github.antonfermat.leetcode.contest.weekly371;

public class Solution4 {
    public int maximumStrongPairXor(int[] nums) {
        for (int num : nums) insert(num);
        int res = 0;
        for (int num : nums) {
            int xor = find(num, num * 2);
            res = Math.max(res, num ^ xor);
        }
        return res;
    }

    // |x - y| <= min(x, y); x ∈ (y, 2 * y)
    public int find(int minNum, int maxNum) {
        var node = root;
        int res = 0;
        for (int i = 20; i >= 0; i--) {
            int index0 = (minNum >> i) & 1;
            int index1 = 1 - index0;
            if (node.children[index1] != null && node.children[index1].min <= maxNum && node.children[index1].max > minNum) {
                res = res | index1 << i;
                node = node.children[index1];
            } else {
                res = res | index0 << i;
                node = node.children[index0];
            }
        }
        return res;
    }

    private void insert(int num) {
        var node = root;
        for (int i = 20; i >= 0; i--) {
            int index = (num >> i) & 1;
            if (node.children[index] == null) node.children[index] = new TreeNode();
            node = node.children[index];
            node.min = Math.min(node.min, num);
            node.max = Math.max(node.max, num);
        }
    }

    private final TreeNode root = new TreeNode();

    private static class TreeNode {
        TreeNode[] children = new TreeNode[2];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
    }
}
