package com.leetcode.stack;

import com.leetcode.array.IntArrayConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrappingRainWaterTest {

    @ParameterizedTest
    @CsvSource( {
            "'0,1,0,2,1,0,1,3,2,1,2,1',6",
            "'4,2,0,3,2,5',9"
    })
    void testTrap(@ConvertWith(IntArrayConverter.class) int[] arr, int expected) {
        int actual = TrappingRainWater.trap(arr);
        assertEquals(expected, actual);
    }
}
