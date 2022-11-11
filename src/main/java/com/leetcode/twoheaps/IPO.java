package com.leetcode.twoheaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public final class IPO {
    private IPO() {
    }

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        final PriorityQueue<Integer> capitalsHeap = new PriorityQueue<>(Comparator.comparingInt(i -> capital[i]));
        final PriorityQueue<Integer> profitHeap = new PriorityQueue<>((i1, i2) -> profits[i2] - profits[i1]);
        for (int i = 0; i < capital.length; i++) {
            capitalsHeap.add(i);
        }
        int restCapital = w;
        for (int i = 0; i < k; i++) {
            while (!capitalsHeap.isEmpty() && capital[capitalsHeap.peek()] <= restCapital) {
                profitHeap.add(capitalsHeap.remove());
            }
            Integer bestProject = profitHeap.poll();
            if (bestProject != null) {
                restCapital += profits[bestProject];
                capitalsHeap.remove(bestProject);
            }
        }
        return restCapital;
    }
}
