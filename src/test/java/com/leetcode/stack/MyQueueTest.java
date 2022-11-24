package com.leetcode.stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MyQueueTest {
    @Test
    @DisplayName("test queue implementation functionality ")
    void test() {
        MyQueue myQueue = new MyQueue();
        assertTrue(myQueue.empty());
        myQueue.push(1);
        assertFalse(myQueue.empty());
        myQueue.push(2);
        assertEquals(1, myQueue.peek());
        assertEquals(1, myQueue.pop());
        myQueue.pop();
        assertTrue(myQueue.empty());
    }

}
