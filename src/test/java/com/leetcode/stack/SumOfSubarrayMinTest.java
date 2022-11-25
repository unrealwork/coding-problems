package com.leetcode.stack;

import com.leetcode.array.IntArrayConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class SumOfSubarrayMinTest {

    @ParameterizedTest
    @CsvSource( {
            "'3,1,2,4',17",
            "'11,81,94,43,3',444"
    })
    void testSumSubarrayMins(@ConvertWith(IntArrayConverter.class) int[] arr, int expected) {
        int actual = SumOfSubarrayMin.sumSubarrayMins(arr);
        Assertions.assertEquals(expected, actual);
    }
}
