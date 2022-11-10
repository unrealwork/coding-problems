package com.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class SnapshotArray {
    private final Map<Integer, Integer> currentSnap;
    private final List<TreeMap<Integer, Integer>> storage;
    private int snapCount = 0;

    public SnapshotArray(int length) {
        this.currentSnap = new HashMap<>();
        storage = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            storage.add(new TreeMap<>());
        }

    }

    public void set(int index, int val) {
        currentSnap.put(index, val);
    }

    public int snap() {
        currentSnap.forEach((index, value) -> storage.get(index)
                .put(snapCount, value));
        return snapCount++;
    }

    public int get(int index, int snapId) {
        if (snapId == snapCount) {
            return currentSnap.getOrDefault(index, 0);
        }
        if (index < 0 || index >= storage.size()) {
            return 0;
        }
        TreeMap<Integer, Integer> valueUpdates = storage.get(index);
        final Map.Entry<Integer, Integer> lastUpdateValue = valueUpdates.floorEntry(snapId);
        if (lastUpdateValue == null) {
            return 0;
        }
        return lastUpdateValue.getValue();
    }
}
