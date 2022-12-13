package com.leetcode.dp;

import com.leetcode.array.IntArrayConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubarrayProductLessThanTest {

    @ParameterizedTest
    @CsvSource( {
            "'10,5,2,6',100,8",
            "'57,44,92,28,66,60,37,33,52,38,29,76,8,75,22',18,1"
    })
    void testNumSubarrayProductLessThanK(@ConvertWith(IntArrayConverter.class) int[] arr, int k, int expected) {
        int actual = SubarrayProductLessThan.numSubarrayProductLessThanK(arr, k);
        assertEquals(expected, actual);
    }
}
