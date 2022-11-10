package com.leetcode.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SnapshotArrayTest {
    @Test
    void testFlow() {
        final SnapshotArray snapshotArray = new SnapshotArray(3);
        snapshotArray.set(0, 5);
        snapshotArray.snap();
        snapshotArray.set(0, 6);
        assertEquals(5, snapshotArray.get(0, 0));
        assertEquals(6, snapshotArray.get(0, 1));
        assertEquals(0, snapshotArray.get(2, 0));
    }

}
