package com.github.antonfermat.leetcode.templates.graph;

import java.util.*;

public class TopologicalSort {

    private List<Integer> topologicalSort(int n, int[][] edges) {
        int[] deg = new int[n];
        var order = new ArrayList<Integer>();
        var graph = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        var q = new LinkedList<Integer>();
        for (int[] e : edges) {
            int from = e[0];
            int to = e[1];
            graph.get(from).add(to);
            deg[to]++;
        }
        for (int i = 0; i < n; i++) {
            if (deg[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            order.add(cur);
            for (int next : graph.get(cur)) {
                deg[next]--;
                if (deg[next] == 0) q.add(next);
            }
        }
        return order;
    }


    public int[] findOrder(int n, int[][] edges) {
        var graph = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; ++i) graph.add(new ArrayList<>());
        int[] inDegree = new int[n];
        for (var p : edges) {
            int from = p[1];
            int to = p[0];
            graph.get(from).add(to);
            inDegree[to]++;
        }

        var zeroDegree = new LinkedList<Integer>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) zeroDegree.add(i);
        }

        int[] result = new int[n];
        int index = 0;
        while (!zeroDegree.isEmpty()) {
            int cur = zeroDegree.poll();
            result[index] = cur;
            index++;
            for (var child : graph.get(cur)) {
                inDegree[child]--;
                if (inDegree[child] == 0) zeroDegree.add(child);
            }
        }

        for (int in : inDegree) {
            if (in != 0) return new int[0];
        }

        return result;
    }
}