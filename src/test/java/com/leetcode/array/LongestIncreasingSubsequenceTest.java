package com.leetcode.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestIncreasingSubsequenceTest {

    @ParameterizedTest
    @CsvSource( {
            "'10,9,2,5,3,7,101,18',4"
    })
    void testLengthOfLIS(@ConvertWith(IntArrayConverter.class) int[] nums, int expected) {
        int actual = LongestIncreasingSubsequence.lengthOfLIS(nums);
        assertEquals(expected, actual);
    }
}
