package com.leetcode.array;

public final class SpiralMatrix2 {
    private SpiralMatrix2() {
    }

    public static int[][] generateMatrix(int n) {
        int[][] dir = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int capacity = n * n;
        int[][] res = new int[n][n];
        int startI = 0;
        int i = startI;
        int startJ = 0;
        int j = startJ;
        int currentDir = 0;
        int shift = 0;
        for (int k = 0; k < capacity; k++) {
            res[i][j] = k + 1;
            int adjI = i + dir[currentDir][0];
            int adjJ = j + dir[currentDir][1];
            if (isNonValid(res, adjI, adjJ, shift)) {
                currentDir++;
                i = i + dir[currentDir][0];
                j = j + dir[currentDir][1];
            } else {
                if (adjI == startI && adjJ == startJ) {
                    shift++;
                    i = adjI + 1;
                    j = adjJ + 1;
                    startI = i;
                    startJ = j;
                    currentDir = 0;
                } else {
                    i = adjI;
                    j = adjJ;
                }
            }
        }
        return res;
    }

    private static boolean isNonValid(int[][] matrix, int i, int j, int shift) {
        return (i < shift || i >= matrix.length - shift || j < shift || j >= matrix[0].length - shift);
    }
}
