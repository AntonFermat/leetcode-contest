package com.github.antonfermat.leetcode.templates.graph;

import java.util.*;

public class UnionFind {
    int[] parent;
    int[] rank;
    int count;

    UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        count = size;
        for (int i = 0; i < size; i++) parent[i] = i;
    }

    int[] parents() {
        for (int i = 0; i < parent.length; i++) parent[i] = find(i);
        return parent;
    }

    int componentsCount() {
        var set = new HashSet<Integer>();
        for (int i = 0; i < parent.length; i++) set.add(find(i));
        return set.size();
    }

    Map<Integer, Set<Integer>> components() {
        var map = new HashMap<Integer, Set<Integer>>();
        for (int i = 0; i < parent.length; i++) {
            map.computeIfAbsent(find(parent[i]), o -> new HashSet<>()).add(i);
        }
        return map;
    }

    boolean isConnected() {
        int p = find(0);
        for (int i = 1; i < parent.length; i++) {
            if (find(i) != p) return false;
        }
        return true;
    }

    int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    boolean union(int x, int y) {
        int fx = find(x), fy = find(y);
        if (fx == fy) return false;

        if (rank[fx] < rank[fy]) parent[fx] = fy;
        else if (rank[fx] > rank[fy]) parent[fy] = fx;
        else {
            parent[fy] = fx;
            rank[fx]++;
        }
        count--;
        return true;
    }
}