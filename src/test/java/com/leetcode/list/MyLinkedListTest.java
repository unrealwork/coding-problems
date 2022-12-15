package com.leetcode.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyLinkedListTest {
    @Test
    void test() {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        assertEquals(1, list.get(0));
        list.addAtTail(3);
        assertEquals(3, list.get(1));
        list.addAtIndex(1, 2);
        assertEquals(2, list.get(1));
        list.deleteAtIndex(1);
        assertEquals(3, list.get(1));
        list.addAtTail(4);
        assertEquals(4, list.get(2));
        list.deleteAtIndex(0);
        assertEquals(3, list.get(0));

    }
}
