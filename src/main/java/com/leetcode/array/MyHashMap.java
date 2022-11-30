package com.leetcode.array;

import java.util.Arrays;

class MyHashMap {
    public static final int NON_EXIST = -1;
    private static final int SIZE = 1000001;
    private final int[] storage = new int[SIZE];

    MyHashMap() {
        Arrays.fill(storage, NON_EXIST);
    }

    void put(int key, int value) {
        storage[key] = value;
    }

    int get(int key) {
        return storage[key];
    }

    void remove(int key) {
        storage[key] = NON_EXIST;
    }
}
