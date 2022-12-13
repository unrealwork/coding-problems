package com.leetcode.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SeatManagerTest {
    @Test
    void test1() {
        SeatManager manager = new SeatManager(5);
        Assertions.assertEquals(1, manager.reserve());
        Assertions.assertEquals(2, manager.reserve());
        manager.unreserve(2);
        Assertions.assertEquals(2, manager.reserve());
        Assertions.assertEquals(3, manager.reserve());
        Assertions.assertEquals(4, manager.reserve());
        Assertions.assertEquals(5, manager.reserve());
        manager.unreserve(5);
    }


    @Test
    void test2() {
        SeatManager manager = new SeatManager(4);
        Assertions.assertEquals(1, manager.reserve());
        manager.unreserve(1);
        Assertions.assertEquals(1, manager.reserve());
        Assertions.assertEquals(2, manager.reserve());
        Assertions.assertEquals(3, manager.reserve());
    }
}
