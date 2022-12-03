package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public final class SpiralMatrix {
    private SpiralMatrix() {
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int[][] dir = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int capacity = matrix.length * matrix[0].length;
        List<Integer> res = new ArrayList<>(capacity);
        int startI = 0;
        int i = startI;
        int startJ = 0;
        int j = startJ;
        int currentDir = 0;
        int shift = 0;
        for (int k = 0; k < capacity; k++) {
            res.add(matrix[i][j]);
            int adjI = i + dir[currentDir][0];
            int adjJ = j + dir[currentDir][1];
            if (isNonValid(matrix, adjI, adjJ, shift)) {
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
