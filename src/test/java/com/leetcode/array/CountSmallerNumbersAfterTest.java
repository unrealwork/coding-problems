package com.leetcode.array;

import com.leetcode.list.IntListConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountSmallerNumbersAfterTest {

    @ParameterizedTest
    @CsvSource( {
            "'5,2,6,1','2,1,1,0'",
            "'-1','0'",
            "'-1,-1','0,0'",
            "'5,5,5,5,5','0,0,0,0,0'"
    })
    void testCountSmaller(@ConvertWith(IntArrayConverter.class) int[] nums,
                          @ConvertWith(IntListConverter.class) List<Integer> expected) {
        List<Integer> actual = CountSmallerNumbersAfter.countSmaller(nums);
        assertEquals(expected, actual);
    }
}
