package com.leetcode.math;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
class CountOddsTest {

    @ParameterizedTest
    @CsvSource( {
            "3,7,3",
            "4,8,2",
            "4,7,2",
            "3,6,2"
    })
    void countOdds(int low, int high, int res) {
        assertEquals(res, CountOdds.countOdds(low, high));
    }
}
