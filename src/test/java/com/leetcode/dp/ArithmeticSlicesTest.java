package com.leetcode.dp;

import com.leetcode.array.IntArrayConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArithmeticSlicesTest {

    @ParameterizedTest
    @CsvSource( {
            "'1,2,3,4',3"
    })
    void testNumberOfArithmeticSlices(@ConvertWith(IntArrayConverter.class) int[] arr,
                                      int expected) {
        assertEquals(expected, ArithmeticSlices.numberOfArithmeticSlices(arr));
    }
}
