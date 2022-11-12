package com.leetcode.twoheaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public final class MedianFinder {


    private static final int TWO = 2;
    private final PriorityQueue<Integer> maxHeap;
    private final PriorityQueue<Integer> minHeap;
    private Double median;

    public MedianFinder() {
        this.maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        this.minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty()) {
            maxHeap.add(num);
        } else {
            final int size = size();
            if (size % TWO == 0) {
                if (num < minHeap.peek()) {
                    maxHeap.add(num);
                } else {
                    maxHeap.add(minHeap.remove());
                    minHeap.add(num);
                }
            } else {
                if (num < maxHeap.peek()) {
                    minHeap.add(maxHeap.remove());
                    maxHeap.add(num);
                } else {
                    minHeap.add(num);
                }
            }
        }
        median = null;
    }

    public double findMedian() {
        if (median == null) {
            median = calcMedian();
        }
        return median;
    }

    private double calcMedian() {
        int size = size();
        if (size % TWO == 0) {
            if (minHeap.isEmpty() || maxHeap.isEmpty()) {
                throw new IllegalStateException();
            }
            return (minHeap.peek().doubleValue() + maxHeap.peek()) / TWO;
        } else {
            if (maxHeap.isEmpty()) {
                throw new IllegalStateException();
            }
            return maxHeap.peek().doubleValue();
        }
    }

    private int size() {
        return minHeap.size() + maxHeap.size();
    }
}
