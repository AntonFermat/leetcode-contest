package com.github.antonfermat.leetcode.templates;

public class Trie {
    void build(String[] words) {
        for (var w : words) {
            var node = root;
            for (var c : w.toCharArray()) {
                if (node.children[c - 'a'] == null) node.children[c - 'a'] = new TrieNode();
                node = node.children[c - 'a'];
            }
            node.end = true;
        }
    }
    boolean find(String word) {
        var node = root;
        for (var c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) return false;
            node = node.children[c - 'a'];
        }
        return node.end;
    }

    TrieNode root = new TrieNode();

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean end = false;
    }
}
