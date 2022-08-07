package com.leetcode.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ConcatenationOfArrayTest {

    @Test
    void testGetConcatenation() {
        int[] nums = new int[] {1, 2, 3};
        assertArrayEquals(new int[] {1, 2, 3, 1, 2, 3}, ConcatenationOfArray.getConcatenation(nums));
    }
}
