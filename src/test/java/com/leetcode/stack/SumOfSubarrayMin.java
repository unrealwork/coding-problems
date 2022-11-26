package com.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public final class SumOfSubarrayMin {
    private static final int MOD = 1000000007;

    private SumOfSubarrayMin() {
    }

    public static int sumSubarrayMins(int[] arr) {
        int sum = arr[0];
        final Deque<Integer> minIndexes = new ArrayDeque<>(arr.length);
        minIndexes.addLast(0);
        int stackSum = sum;
        for (int i = 1; i < arr.length; i++) {
            int cur = arr[i];
            int lastRemoved = i;
            while (!minIndexes.isEmpty() && arr[minIndexes.peekLast()] > cur) {
                int lastMinIndex = minIndexes.removeLast();
                int lastMinValue = arr[lastMinIndex];
                final int prevMinIndex = prevIndex(minIndexes);
                int removedCount = lastRemoved - (prevMinIndex + 1);
                lastRemoved = prevMinIndex + 1;
                stackSum -= lastMinValue * removedCount;
            }
            final int prevMinIndex = prevIndex(minIndexes);
            minIndexes.addLast(i);
            stackSum += arr[i] * (i - prevMinIndex);
            sum = safeAdd(stackSum, sum);
        }
        return sum;
    }

    private static int prevIndex(Deque<Integer> minIndexes) {
        if (minIndexes.isEmpty()) {
            return -1;
        }
        return minIndexes.peekLast();
    }

    private static int safeAdd(int a, int b) {
        return (a + b) % MOD;
    }
}
