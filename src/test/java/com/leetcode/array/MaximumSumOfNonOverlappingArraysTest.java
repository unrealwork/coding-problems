package com.leetcode.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumSumOfNonOverlappingArraysTest {

    @ParameterizedTest
    @CsvSource( {
            "'0,6,5,2,2,5,1,9,4',1,2,20",
            "'3,8,1,3,2,1,8,9,0',3,2,29",
            "'2,1,5,6,0,9,5,0,3,8',4,3,31"
    })
    void testMaxSumTwoNoOverlap(@ConvertWith(IntArrayConverter.class) int[] nums, int firstLen, int secLen, int expected) {
        int actual = MaximumSumOfNonOverlappingArrays.maxSumTwoNoOverlap(nums, firstLen, secLen);
        assertEquals(expected, actual);
    }
}
