package com.leetcode.dp;

import com.leetcode.array.IntArrayConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BestTimeToBuySellTransactionFeeTest {

    @ParameterizedTest
    @CsvSource( {
            "'1,3,2,8,4,9',2,8",
            "'1,3,7,5,10,3',3,6",
            "'1,4,6,2,8,3,10,14',3,13"
    })
    void testMaxProfit(@ConvertWith(IntArrayConverter.class) int[] arr, int fee, int expected) {
        int actual = BestTimeToBuySellTransactionFee.maxProfit(arr, fee);
        assertEquals(expected, actual);
    }
}
