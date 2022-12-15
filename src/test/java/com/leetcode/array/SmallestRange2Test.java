package com.leetcode.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SmallestRange2Test {

    @ParameterizedTest
    @CsvSource( {
            "'1',0,0",
            "'0,10',2,6",
            "'1,3,6',3,3"
    })
    void smallestRangeII(@ConvertWith(IntArrayConverter.class) int[] nums, int k, int expected) {
        assertEquals(expected, SmallestRange2.smallestRangeII(nums, k));
    }
}
