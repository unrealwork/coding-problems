package com.leetcode.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PerfectSquaresTest {

    @ParameterizedTest
    @CsvSource( {
            "2,2",
            "12,3",
            "4,1",
            "13,2"
    })
    void testNumSquares(int n, int expected) {
        int actual = PerfectSquares.numSquares(n);
        Assertions.assertEquals(expected, actual);
    }
}
