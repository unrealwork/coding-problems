package com.leetcode.graph;

final class OutOfBoundaryPaths {
    public static final int MODULO = 1000000007;

    private OutOfBoundaryPaths() {
    }

    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][] dp = new int[m][n];
        int res = 0;
        for (int i = 0; i < maxMove; i++) {
            int[][] next = new int[m][n];
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    if (i == 0) {
                        dp[row][col] = startScore(m, n, row, col);
                    } else {
                        long nextScore = nextScore(dp, row, col);
                        next[row][col] = (int) nextScore;
                    }
                }
            }
            if (i != 0) {
                dp = next;
            }
            res = (res + dp[startRow][startColumn]) % MODULO;
        }
        return res;
    }

    private static int nextScore(int[][] dp, int row, int col) {
        long nextScore = ((long) score(row - 1, col, dp)
                + score(row + 1, col, dp)
                + score(row, col + 1, dp)
                + score(row, col - 1, dp)) % MODULO;
        return (int) nextScore;
    }

    private static int startScore(int m, int n, int row, int col) {
        int res = 0;
        if (row == 0) {
            res++;
        }
        if (col == 0) {
            res++;
        }
        if (row == m - 1) {
            res++;
        }
        if (col == n - 1) {
            res++;
        }
        return res;
    }

    static int score(int row, int column, int[][] dp) {
        if (row < 0 || row >= dp.length) {
            return 0;
        }
        if (column < 0 || column >= dp[row].length) {
            return 0;
        }
        return dp[row][column];
    }
}
