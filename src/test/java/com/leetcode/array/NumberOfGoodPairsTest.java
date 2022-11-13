package com.leetcode.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfGoodPairsTest {

    @ParameterizedTest
    @CsvSource( {
            "'1,2,3,1,1,3', 4",
            "'1,1,1,1', 6",
            "'1,2,3', 0"
    })
    void numIdenticalPairs(@ConvertWith(IntArrayConverter.class) int[] nums, int expected) {
        assertEquals(expected, NumberOfGoodPairs.numIdenticalPairs(nums));
    }
}
