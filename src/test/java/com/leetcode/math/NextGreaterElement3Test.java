package com.leetcode.math;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NextGreaterElement3Test {

    @ParameterizedTest
    @CsvSource( {
            "12,21",
            "21,-1",
            "124651,125146",
            "1246541,1251446",
            "12465,12546",
            "5,-1"
    })
    void testNextGreaterElement(int n, int expected) {
        assertEquals(expected, NextGreaterElement3.nextGreaterElement(n));
    }
}
