package com.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class DetectRepeatedPatternTest {

    @ParameterizedTest
    @CsvSource( {
            "'1,2,4,4,4,4',1,3,true",
            "'1,2,1,2,1,3',2,3,false",
            "'2,2',1,2,true"
    })
    void containsPattern(@ConvertWith(IntArrayConverter.class) int[] nums, int m, int k, boolean expected) {
        boolean actual = DetectRepeatedPattern.containsPattern(nums, m, k);
        Assertions.assertEquals(expected, actual);
    }
}
