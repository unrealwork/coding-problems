package com.leetcode.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public final class RandomizedSet {
    private final Map<Integer, Integer> indexMap;
    private final ArrayList<Integer> storage;
    private final Random random;

    public RandomizedSet() {
        this.indexMap = new HashMap<>();
        this.storage = new ArrayList<>();
        this.random = new Random();
    }

    static RandomizedSet of(int... elements) {
        final RandomizedSet set = new RandomizedSet();
        for (int element : elements) {
            set.insert(element);
        }
        return set;
    }

    public boolean insert(int val) {
        if (indexMap.containsKey(val)) {
            return false;
        }
        storage.add(val);
        indexMap.put(val, storage.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (indexMap.containsKey(val)) {
            int index = indexMap.remove(val);
            storage.set(index, null);
            int lastIndex = storage.size() - 1;
            if (index != lastIndex) {
                Integer lastVal = storage.get(lastIndex);
                storage.set(index, lastVal);
                indexMap.put(lastVal, index);
            }
            storage.remove(lastIndex);
            return true;
        }
        return false;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(storage.size());
        return storage.get(randomIndex);
    }

    @Override
    public String toString() {
        return storage.toString();
    }
}
