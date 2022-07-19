package com.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class FindDuplicateNumberTest {

    @ParameterizedTest
    @CsvSource( {
            "'1,3,4,2,2',2",
            "'3,1,3,4,2',3",
            "'4,3,1,4,2',4",
            "'2,2,2,2,2',2",
            "'1,3,4,2,1',1",
            "'1,3,1,2,4',1"
    })
    void testFindDuplicate(@ConvertWith(IntArrayConverter.class) int[] nums, int expected) {
        int actual = FindDuplicateNumber.findDuplicate(nums);
        Assertions.assertEquals(expected, actual);
    }
}
