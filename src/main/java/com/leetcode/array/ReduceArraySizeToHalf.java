package com.leetcode.array;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

final class ReduceArraySizeToHalf {
    private ReduceArraySizeToHalf() {
    }

    static int minSetSize(int[] arr) {
        Map<Integer, Integer> dict = new HashMap<>(arr.length);
        for (int n : arr) {
            dict.putIfAbsent(n, 0);
            dict.computeIfPresent(n, (k, v) -> v + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparing(dict::get).reversed());
        dict.forEach((k, v) -> heap.add(k));
        int halfLen = arr.length / 2;
        int reducedSize = 0;
        int res = 0;
        while (!heap.isEmpty() && reducedSize < halfLen) {
            reducedSize += dict.get(heap.remove());
            res++;
        }
        return res;
    }
}
