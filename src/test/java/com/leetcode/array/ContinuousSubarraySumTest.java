package com.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class ContinuousSubarraySumTest {

    @ParameterizedTest
    @CsvSource(value = {
            "'23,2,4,6,7',6,true",
            "'23,2,6,4,7',6,true",
            "'23,2,6,4,7',13,false",
            "'1,2,12',6,false",
            "'0,0',1,true",
            "'23,2,4,6,6',7,true",
            "'5,0,0,0',3,true",
            "'0',1,false"
    })
    void testCheckSubarraySum(@ConvertWith(IntArrayConverter.class) int[] arr, int k, boolean expected) {
        Assertions.assertEquals(expected, ContinuousSubarraySum.checkSubarraySum(arr, k));
    }


}
