package com.leetcode.dp;

import com.leetcode.array.IntArrayConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BestTimeToBuySellCooldownTest {

    @ParameterizedTest
    @CsvSource( {
            "'1,2,3,0,2',3"
    })
    void testMaxProfit(@ConvertWith(IntArrayConverter.class) int[] prices,
                       int expected) {
        assertEquals(expected, BestTimeToBuySellCooldown.maxProfit(prices));
    }
}
