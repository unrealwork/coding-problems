package com.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class SumOfAllOddLengthSubarraysTest {

    @ParameterizedTest
    @CsvSource( {
            "'1,4,2,5,3',58",
            "'1,4,2,5,3,6',98"
    })
    void testSumOddLengthSubarrays(@ConvertWith(IntArrayConverter.class) int[] arr, int expected) {
        Assertions.assertEquals(expected, SumOfAllOddLengthSubarrays.sumOddLengthSubarrays(arr));
    }
}
