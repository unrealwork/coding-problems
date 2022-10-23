package com.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class SetMismatchTest {

    @ParameterizedTest
    @CsvSource( {
            "'1,2,2,4','2,3'",
            "'1,1','1,2'"
    })
    void findErrorNums(@ConvertWith(IntArrayConverter.class) int[] nums,
                       @ConvertWith(IntArrayConverter.class) int[] expected) {
        int[] actual = SetMismatch.findErrorNums(nums);
        Assertions.assertArrayEquals(expected, actual);
    }
}
