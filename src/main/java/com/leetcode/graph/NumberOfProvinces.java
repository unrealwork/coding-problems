package com.leetcode.graph;

public final class NumberOfProvinces {
    private NumberOfProvinces() {
    }

    public static int findCircleNum(int[][] isConnected) {
        int m = isConnected.length;
        boolean[] visited = new boolean[m];
        int count = 0;
        for (int i = 0; i < m; i++) {
            if (!visited[i]) {
                coverProvince(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }

    private static void coverProvince(int[][] graph, boolean[] visited, int startI) {
        for (int j = 0; j < graph[startI].length; j++) {
            if (graph[startI][j] > 0 && !visited[j]) {
                visited[j] = true;
                coverProvince(graph, visited, j);
            }
        }
    }
}
