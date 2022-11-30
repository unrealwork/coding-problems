package com.leetcode.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyHashMapTest {
    @Test
    void test() {
        MyHashMap map = new MyHashMap();
        assertEquals(-1, map.get(2));
        map.put(2, 3);
        assertEquals(3, map.get(2));
        map.put(2, 4);
        assertEquals(4, map.get(2));
        map.remove(2);
        assertEquals(-1, map.get(2));
    }
}
