package com.leetcode.stack;

import com.leetcode.array.IntArrayConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class StockSpannerTest {

    @ParameterizedTest
    @CsvSource( {
            "'100,80,60,70,60,75,85','1,1,1,2,1,4,6'"
    })
    void testNext(@ConvertWith(IntArrayConverter.class) int[] prices,
                  @ConvertWith(IntArrayConverter.class) int[] expected) {
        int[] actual = new int[prices.length];
        final StockSpanner stockSpanner = new StockSpanner();
        for (int i = 0; i < prices.length; i++) {
            actual[i] = stockSpanner.next(prices[i]);
        }
        Assertions.assertArrayEquals(expected, actual);
    }
}
