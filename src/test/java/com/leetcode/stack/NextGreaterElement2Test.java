package com.leetcode.stack;

import com.leetcode.array.IntArrayConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class NextGreaterElement2Test {

    @ParameterizedTest
    @CsvSource( {
            "'1,2,3,4,3','2,3,4,-1,4'",
            "'1,2,1','2,-1,2'",
            "'5,4,3,2,1','-1,5,5,5,5'"
    })
    void tesNextGreaterElements(@ConvertWith(IntArrayConverter.class) int[] nums,
                                @ConvertWith(IntArrayConverter.class) int[] expected) {
        int[] actual = NextGreaterElement2.nextGreaterElements(nums);
        assertArrayEquals(expected, actual);
    }
}
