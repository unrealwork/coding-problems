package com.leetcode.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public final class ShortestBinaryPath {
    private static final int[][] SHIFT = new int[][] {
            {1, 0}, {-1, 0}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}, {0, -1}, {0, 1}
    };

    private ShortestBinaryPath() {
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], -1);
        }
        return shortDistance(grid, dist);
    }

    private static int shortDistance(int[][] grid, int[][] dist) {
        final Deque<int[]> nearest = new ArrayDeque<>();
        if (grid[0][0] == 0) {
            dist[0][0] = 1;
            nearest.add(new int[] {0, 0});
        }
        int m = grid.length;
        int n = grid[0].length;
        while (!nearest.isEmpty()) {
            int[] v = nearest.removeLast();
            int visitingI = v[0];
            int visitingJ = v[1];
            for (int[] s : SHIFT) {
                int adjI = visitingI + s[0];
                int adjJ = visitingJ + s[1];
                boolean isValidCell = adjI > -1 && adjJ > -1 && adjI < m && adjJ < n;
                if (isValidCell && grid[adjI][adjJ] == 0 && dist[adjI][adjJ] == -1) {
                    dist[adjI][adjJ] = dist[visitingI][visitingJ] + 1;
                    nearest.addFirst(new int[] {adjI, adjJ});
                }
            }
        }
        return dist[m - 1][n - 1];
    }
}
