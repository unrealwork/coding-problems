package com.leetcode.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ReorderPowerOf2Test {

    @ParameterizedTest
    @CsvSource( {
            "4021,true",
            "10,false",
            "1,true",
    })
    void testReorderedPowerOf2(int n, boolean expected) {
        Assertions.assertEquals(expected, ReorderPowerOf2.reorderedPowerOf2(n));
    }
}
