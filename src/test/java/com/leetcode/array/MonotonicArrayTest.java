package com.leetcode.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MonotonicArrayTest {

    @ParameterizedTest
    @CsvSource( {
            "'',true",
            "'1,1',true",
            "'1,1,2',true",
            "'1,1,-1',true",
            "'1,1,-1, -1',true",
            "'1,1,-1, -1, -2',true",
            "'1,1,-1, -1, 1',false"
    })
    void testIsMonotonic(@ConvertWith(IntArrayConverter.class) int[] arr, boolean expected) {
        boolean actual = MonotonicArray.isMonotonic(arr);
        assertEquals(expected, actual);
    }
}
