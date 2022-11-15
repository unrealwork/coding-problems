package com.leetcode.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SubstractProductSumDigitsTest {

    @ParameterizedTest
    @CsvSource( {
            "234, 15"
    })
    void subtractProductAndSum(int num, int expected) {
        Assertions.assertEquals(expected, SubtractProductSumDigits.subtractProductAndSum(num));
    }
}
