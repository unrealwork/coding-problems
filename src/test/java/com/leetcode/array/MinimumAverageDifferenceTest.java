package com.leetcode.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumAverageDifferenceTest {

    @ParameterizedTest
    @CsvSource( {
            "'2,5,3,9,5,3',3",
            "'1,1,1,1,1',0",
            "'4,2,0',2"
    })
    void testMinimumAverageDifference(@ConvertWith(IntArrayConverter.class) int[] arr, int expected) {
        assertEquals(expected, MinimumAverageDifference.minimumAverageDifference(arr));
    }
}
