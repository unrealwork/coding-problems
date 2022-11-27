package com.leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public final class LastStoneWeight {
    private LastStoneWeight() {
    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int s : stones) {
            pq.add(s);
        }
        while (pq.size() > 1) {
            Integer x = pq.remove();
            Integer y = pq.remove();
            int compareRes = x.compareTo(y);
            if (compareRes != 0) {
                pq.add(x - y);
            }
        }
        if (pq.isEmpty()) {
            return 0;
        }
        return pq.peek();
    }
}
