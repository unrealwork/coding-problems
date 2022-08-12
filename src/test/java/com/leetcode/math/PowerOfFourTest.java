package com.leetcode.math;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PowerOfFourTest {

    @ParameterizedTest
    @CsvSource( {
            "-1,false",
            "1,true",
            "2,false",
            "8,false",
            "4,true",
            "4096,true"
    })
    void isPowerOfFour(int n, boolean expected) {
        assertEquals(expected, PowerOfFour.isPowerOfFour(n));
    }
}
