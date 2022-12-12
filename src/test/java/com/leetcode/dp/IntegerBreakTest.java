package com.leetcode.dp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IntegerBreakTest {

    @ParameterizedTest
    @CsvSource( {
            "10,36",
            "4,4",
            "5,6",
            "6,9"
    })
    void testIntegerBreak(int n, int expected) {
        int actual = IntegerBreak.integerBreak(n);
        assertEquals(expected, actual);
    }
}
