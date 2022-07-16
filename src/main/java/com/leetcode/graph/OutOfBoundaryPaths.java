package com.leetcode.graph;

final class OutOfBoundaryPaths {
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
                        startScore(m, n, dp, row, col);
                    } else {
                        next[row][col] = score(row - 1, col, dp)
                                + score(row + 1, col, dp)
                                + score(row, col + 1, dp)
                                + score(row, col - 1, dp);
                    }
                }
            }
            if (i != 0) {
                dp = next;
            }
            res += dp[startRow][startColumn];
        }
        return res;
    }

    private static void startScore(int m, int n, int[][] dp, int row, int col) {
        if (row == 0) {
            dp[row][col] += 1;
        }
        if (col == 0) {
            dp[row][col] += 1;
        }
        if (row == m - 1) {
            dp[row][col] += 1;
        }
        if (col == n - 1) {
            dp[row][col] += 1;
        }
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
