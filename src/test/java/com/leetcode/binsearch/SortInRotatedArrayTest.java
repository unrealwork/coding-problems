package com.leetcode.binsearch;

import com.leetcode.array.IntArrayConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SortInRotatedArrayTest {

    @ParameterizedTest
    @CsvSource( {
            "'4,5,6,7,0,1,2',0,4",
            "'4,5,6,7,0,1,2',3,-1",
            "'1',0,-1",
            "'0,1,2,3,4,5,6,7',4,4",
            "'2,4,5,6,7,0,1',0,5",
            "'2,4,5,6,7,0,1',5,2",
            "'5,1,3',5,0",
            "'6,7,8,1,2,3,4,5',6,0"
    })
    void testSearch(@ConvertWith(IntArrayConverter.class) int[] nums, int target, int expected) {
        int actual = SortInRotatedArray.search(nums, target);
        assertEquals(expected, actual);
    }
}
