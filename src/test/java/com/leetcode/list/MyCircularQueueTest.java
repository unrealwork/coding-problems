package com.leetcode.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MyCircularQueueTest {
    @Test
    void test() {
        MyCircularQueue cQueue = new MyCircularQueue(3);
        assertTrue(cQueue.enQueue(1));
        assertTrue(cQueue.enQueue(2));
        assertTrue(cQueue.enQueue(3));
        assertFalse(cQueue.enQueue(4));
        assertEquals(1, cQueue.Front());
        assertEquals(3, cQueue.Rear());
        assertTrue(cQueue.deQueue());
        assertTrue(cQueue.enQueue(4));
        assertEquals(4, cQueue.Rear());
    }
}
