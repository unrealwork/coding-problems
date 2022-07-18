package com.leetcode.array;

final class NumSubmatricesSumTarget {
    private NumSubmatricesSumTarget() {
    }

    static int numSubmatrixSumTarget(int[][] matrix, int target) {
        int count = 0;
        int[][] p = prefixSumMatrix(matrix);
        for (int row1 = 0; row1 < p.length; row1++) {
            for (int col1 = 0; col1 < p[row1].length; col1++) {
                for (int row2 = row1; row2 < p.length; row2++) {
                    for (int col2 = col1; col2 < p[row2].length; col2++) {
                        int mSum = getMatrixSum(row1, col1, row2, col2, p);
                        if (mSum == target) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    static int getMatrixSum(int x1, int y1, int x2, int y2, int[][] p) {
        return pSum(p, x2, y2) - pSum(p, x1 - 1, y2) - pSum(p, x2, y1 - 1)
                + pSum(p, x1 - 1, y1 - 1);
    }

    private static int pSum(int[][] p, int x, int y) {
        if (x < 0 || y < 0) {
            return 0;
        }
        return p[x][y];
    }

    static int[][] prefixSumMatrix(int[][] matrix) {
        int[][] p = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            p[i] = new int[matrix[i].length];
            if (i > 0) {
                p[i][0] = matrix[i][0] + p[i - 1][0];
                for (int j = 1; j < p[i].length; j++) {
                    p[i][j] = p[i - 1][j] + p[i][j - 1] - p[i - 1][j - 1] + matrix[i][j];
                }
            } else {
                p[i][0] = matrix[i][0];
                for (int j = 1; j < p[i].length; j++) {
                    p[i][j] = p[i][j - 1] + matrix[i][j];
                }
            }
        }
        return p;
    }
}
