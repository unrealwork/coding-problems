package com.leetcode.impl;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CircularGameTest {

    @ParameterizedTest
    @CsvSource( {
            "5,2,3"
    })
    void testFindTheWinner(int n, int k, int expected) {
        int actual = CircularGame.findTheWinner(n, k);
        assertEquals(expected, actual);
    }
}
