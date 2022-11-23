package com.leetcode.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PopulatingRightPointerTest {

    @Test
    void testConnect() {
        Node left = new Node(2, null, null, null);
        Node right = new Node(3, null, null, null);
        Node node = new Node(1, left, right, null);
        Node actual = PopulatingRightPointer.connect(node);
        Assertions.assertEquals(node, actual);
        Assertions.assertEquals(left.next, right);
        Assertions.assertNull(right.next);
    }
}
