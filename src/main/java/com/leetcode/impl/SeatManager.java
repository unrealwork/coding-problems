package com.leetcode.impl;

public final class SeatManager {


    private final int[] heap;
    private int capacity;

    public SeatManager(int n) {
        this.heap = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            heap[i - 1] = i;
        }
        capacity = n;
    }

    private static int left(int i) {
        return 2 * i + 1;
    }

    private static int parent(int i) {
        return (i - 1) / 2;
    }

    public int reserve() {
        return remove();
    }

    public void unreserve(int seatNumber) {
        insert(seatNumber);
    }

    private int remove() {
        capacity--;
        swap(0, capacity);
        int i = 0;
        int limit = parent(capacity - 1);
        if (capacity > 1) {
            while (i <= limit && (heap[i] > heap[left(i)] || heap[i] > heap[right(i)])) {
                int rightI = right(i);
                int leftI = left(i);
                final int swapI;
                if (rightI < capacity && heap[leftI] > heap[rightI]) {
                    swapI = rightI;
                } else {
                    if (heap[leftI] < heap[i]) {
                        swapI = leftI;
                    } else {
                        break;
                    }
                }
                swap(i, swapI);
                i = swapI;
            }
        }
        return heap[capacity];
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private void insert(int k) {
        heap[capacity] = k;
        int i = capacity;
        while (i > 0 && heap[parent(i)] > heap[i]) {
            swap(parent(i), i);
            i = parent(i);
        }
        capacity++;
    }

    void swap(int i, int j) {
        if (i != j) {
            int tmp = heap[i];
            heap[i] = heap[j];
            heap[j] = tmp;
        }
    }

}
