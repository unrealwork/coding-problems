package com.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class ReduceArraySizeToHalfTest {

    @ParameterizedTest
    @CsvSource( {
            "'3,3,3,3,5,5,5,2,2,7',2",
            "'7,7,7,7,7,7',1",
            "'1,2,3,4,5,6,7,8,9,10',5"
    })
    void testMinSetSize(@ConvertWith(IntArrayConverter.class) int[] nums, int expected) {
        Assertions.assertEquals(expected, ReduceArraySizeToHalf.minSetSize(nums));
    }
}
