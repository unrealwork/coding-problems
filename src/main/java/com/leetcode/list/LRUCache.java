package com.leetcode.list;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public final class LRUCache {
    private final Map<Integer, Integer> map;
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<>();
    }

    @SuppressWarnings("squid:S3824")
    public int get(int key) {
        Integer value = map.get(key);
        if (value != null) {
            map.remove(key);
            map.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
        } else {
            if (map.size() == capacity) {
                Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
                iterator.next();
                iterator.remove();
            }
        }
        map.put(key, value);
    }
}
