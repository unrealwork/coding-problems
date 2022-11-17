package com.leetcode.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SignOfProductTest {
    @ParameterizedTest
    @CsvSource( {
            "'-1,-2,-3,-4,3,2,1', 1",
            "'1,5,0,2,-3', 0",
            "'-1,1,-1,1,-1', -1"
    })
    void testArraySign(@ConvertWith(IntArrayConverter.class) int[] nums, int sign) {
        assertEquals(sign, SignOfProduct.arraySign(nums));
    }
}
