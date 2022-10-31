package com.leetcode.array;

public final class ToeplitzMatrix {
    private ToeplitzMatrix() {

    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        int h = matrix.length;
        if (h < 1) {
            return true;
        }
        int w = matrix[0].length;
        int maxSize = Math.min(h, w);
        for (int i = h - 1; i > -1; i--) {
            boolean isToeplitzDiag = isToeplitzDiag(matrix, i, 0, Math.min(h - i, maxSize));
            if (!isToeplitzDiag) {
                return false;
            }
        }
        for (int j = w - 1; j > 0; j--) {
            boolean isToeplitzDiag = isToeplitzDiag(matrix, 0, j, Math.min(w - j, maxSize));
            if (!isToeplitzDiag) {
                return false;
            }
        }
        return true;
    }

    private static boolean isToeplitzDiag(int[][] matrix, int startI, int startJ, int len) {
        for (int i = 1; i < len; i++) {
            if (matrix[startI + i][startJ + i] != matrix[startI][startJ]) {
                return false;
            }
        }
        return true;
    }
}

