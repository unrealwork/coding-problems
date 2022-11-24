package com.leetcode.array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public final class ZeroOneMatrix {
    private ZeroOneMatrix() {
    }


    public static int[][] updateMatrix(int[][] mat) {
        return new Solver(mat).solve();
    }

    private static final class Solver {
        private static final int[][] SHIFTS = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        private final int[][] mat;
        private final int m;
        private final int n;

        Solver(int[][] mat) {
            this.mat = mat;
            this.m = mat.length;
            this.n = mat[0].length;
        }

        private static int[][] initDist(int m, int n) {
            int[][] dist = new int[m][n];
            for (int[] ints : dist) {
                Arrays.fill(ints, Integer.MAX_VALUE);
            }
            return dist;
        }

        int[][] solve() {
            int[][] dist = initDist(m, n);
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == 0) {
                        deque.addFirst(i);
                        deque.addFirst(j);
                        dist[i][j] = 0;
                    }
                }
            }
            distBfs(dist, deque);
            return dist;
        }

        private void distBfs(int[][] dist, Deque<Integer> deque) {
            while (!deque.isEmpty()) {
                int curI = deque.removeLast();
                int curJ = deque.removeLast();
                for (int[] shift : SHIFTS) {
                    int adjI = curI + shift[0];
                    int adjJ = curJ + shift[1];
                    if (isValid(adjI, adjJ) && dist[adjI][adjJ] > dist[curI][curJ] + 1) {
                        dist[adjI][adjJ] = dist[curI][curJ] + 1;
                        deque.addFirst(adjI);
                        deque.addFirst(adjJ);
                    }
                }
            }
        }

        private boolean isValid(int i, int j) {
            return i > -1 && i < m && j > -1 && j < n;
        }
    }
}
