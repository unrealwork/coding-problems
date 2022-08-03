package com.leetcode.array;

import java.util.PriorityQueue;

final class KthSmallestInSortedMatrix {
    private KthSmallestInSortedMatrix() {
    }

    static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                heap.add(matrix[i][j]);
            }
        }
        int res = heap.remove();
        int i = 1;
        while (i < k) {
            res = heap.remove();
            i++;
        }
        return res;
    }
}
