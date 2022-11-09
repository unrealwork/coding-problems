package com.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

class StockSpanner {

    private final Deque<int[]> deque;

    StockSpanner() {
        deque = new ArrayDeque<>();
    }

    int next(int price) {
        int spanDaysCount = 0;
        while (!deque.isEmpty()) {
            int[] lastResults = deque.peekLast();
            if (lastResults[0] <= price) {
                spanDaysCount += lastResults[1];
                deque.removeLast();
            } else {
                break;
            }
        }
        deque.add(new int[] {price, spanDaysCount + 1});
        return spanDaysCount + 1;
    }
}
