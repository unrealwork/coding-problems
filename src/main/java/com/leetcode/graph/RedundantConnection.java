package com.leetcode.graph;

public final class RedundantConnection {
    private RedundantConnection() {
    }

    public static int[] findRedundantConnection(int[][] edges) {
        final int[] union = new int[edges.length];
        final int[] rank = new int[edges.length];
        for (int i = 0; i < union.length; i++) {
            union[i] = i;
        }
        for (int[] edge : edges) {
            int[] cycleEdge = union(union, rank, edge);
            if (cycleEdge.length != 0) {
                return cycleEdge;
            }
        }
        return new int[] {};
    }

    private static int[] union(int[] union, int[] rank, int[] edge) {
        int from = edge[0] - 1;
        int to = edge[1] - 1;
        int fromRoot = root(union, from);
        int toRoot = root(union, to);
        if (fromRoot == toRoot) {
            return edge;
        }
        mergeTrees(union, rank, fromRoot, toRoot);
        return new int[] {};
    }

    private static void mergeTrees(int[] union, int[] rank, int fromRoot, int toRoot) {
        if (rank[fromRoot] > rank[toRoot]) {
            rank[fromRoot]++;
            for (int i = 0; i < union.length; i++) {
                if (union[i] == toRoot) {
                    union[i] = fromRoot;
                }
            }
        } else {
            rank[toRoot]++;
            for (int i = 0; i < union.length; i++) {
                if (union[i] == fromRoot) {
                    union[i] = toRoot;
                }
            }
        }
    }

    private static int root(int[] union, int i) {
        int res = i;
        while (union[res] != res) {
            res = union[res];
        }
        return res;
    }
}
