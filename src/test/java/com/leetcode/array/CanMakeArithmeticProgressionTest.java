package com.leetcode.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CanMakeArithmeticProgressionTest {

    @ParameterizedTest
    @CsvSource( {
            "'3,5,1', true",
            "'1,2,4', false"
    }
    )
    void testCanMakeArithmeticProgression(@ConvertWith(IntArrayConverter.class) int[] nums, boolean expected) {
        assertEquals(expected, CanMakeArithmeticProgression.canMakeArithmeticProgression(nums));
    }
}
