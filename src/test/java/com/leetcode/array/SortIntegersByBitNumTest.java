package com.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class SortIntegersByBitNumTest {

    @ParameterizedTest
    @CsvSource( {
            "'0,1,2,3,4,5,6,7,8','0,1,2,4,8,3,5,6,7'"
    })
    void testSortByBits(@ConvertWith(IntArrayConverter.class) int[] arr,
                        @ConvertWith(IntArrayConverter.class) int[] expected) {
        int[] actual = SortIntegersByBitNum.sortByBits(arr);
        Assertions.assertArrayEquals(expected, actual);
    }
}
