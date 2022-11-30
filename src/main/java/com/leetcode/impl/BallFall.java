package com.leetcode.impl;

public final class BallFall {
    private BallFall() {

    }

    public static int[] findBall(int[][] grid) {
        int n = grid[0].length;
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[i] = i;
        }
        for (int[] row : grid) {
            for (int j = 0; j < row.length; j++) {
                int cur = pos[j];
                if (cur != -1) {
                    pos[j] = nextPos(cur, row, pos[j]);
                }
            }
        }
        return pos;
    }

    private static int nextPos(int cur, int[] row, int curPos) {
        int n = row.length;
        if (cur == 0 && row[0] == -1 || cur == n - 1 && row[n - 1] == 1) {
            return -1;
        } else {
            if (row[cur] == 1 && row[cur + 1] == -1 || row[cur] == -1 && row[cur - 1] == 1) {
                return -1;
            } else {
                return curPos + row[cur];
            }
        }
    }
}
