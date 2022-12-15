package com.leetcode.array;

final class PossibleRotatedMatrix {
    private PossibleRotatedMatrix() {
    }

    static boolean findRotation(int[][] mat, int[][] target) {
        return isEqual(mat, target) || isFlipped(mat, target)
                || isTurnedClockwise(mat, target)
                || isTurnedClockwise(target, mat);
    }

    private static boolean isEqual(int[][] mat, int[][] target) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != target[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isFlipped(int[][] mat, int[][] target) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != target[n - 1 - i][n - 1 - j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isTurnedClockwise(int[][] m, int[][] t) {
        int n = m.length;
        int sideSize = n;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < sideSize; j++) {
                if (m[i][j] != t[j][n - 1 - i]) {
                    return false;
                }
                if (m[j][n - 1 - i] != t[n - 1 - i][n - 1 - j]) {
                    return false;
                }

                if (m[n - 1 - i][j] != t[j][i]) {
                    return false;
                }

                if (m[j][i] != t[i][n - 1 - j]) {
                    return false;
                }
            }
            sideSize--;
        }
        return true;
    }
}
