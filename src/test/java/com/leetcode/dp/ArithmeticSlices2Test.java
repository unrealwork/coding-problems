package com.leetcode.dp;

import com.leetcode.array.IntArrayConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArithmeticSlices2Test {

    @ParameterizedTest
    @CsvSource( {
            "'2,4,6,8,10',7",
            "'7,7,7,7,7',16",
            "'0,2000000000,-294967296',0"
    })
    void testNumberOfArithmeticSlices(@ConvertWith(IntArrayConverter.class) int[] arr, int expected) {
        int actual = ArithmeticSlices2.numberOfArithmeticSlices(arr);
        assertEquals(expected, actual);
    }
}
