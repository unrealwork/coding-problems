package com.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class LargestPerimeterTriangleTest {

    @ParameterizedTest
    @CsvSource( {
            "'1,2,2', 5",
            "'1,2,1', 0"
    })
    void testLargestPerimeter(@ConvertWith(IntArrayConverter.class) int[] arr, int expected) {
        Assertions.assertEquals(expected, LargestPerimeterTriangle.largestPerimeter(arr));
    }
}
