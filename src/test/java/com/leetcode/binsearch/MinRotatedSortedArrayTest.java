package com.leetcode.binsearch;

import com.leetcode.array.IntArrayConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinRotatedSortedArrayTest {

    @ParameterizedTest
    @CsvSource( {
            "'3,4,5,1,2',1",
            "'4,5,6,7,0,1,2',0",
            "'11,13,15,17',11"
    })
    void testFindMin(@ConvertWith(IntArrayConverter.class) int[] arr, int expected) {
        assertEquals(expected, MinRotatedSortedArray.findMin(arr));
    }
}
