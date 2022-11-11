package com.leetcode.twoheaps;

import com.leetcode.array.IntArrayConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class IPOTest {

    @ParameterizedTest
    @CsvSource( {
            "2, 0, '1,2,3', '0,1,1', 4",
            "3, 0, '1,2,3', '0,1,2', 6",
            "2, 1, '2,4,6,8', '1,2,2,3' , 11"
    })
    void testFindMaximizedCapital(int k, int w,
                                  @ConvertWith(IntArrayConverter.class) int[] capitals,
                                  @ConvertWith(IntArrayConverter.class) int[] profits,
                                  int expected) {
        Assertions.assertEquals(expected, IPO.findMaximizedCapital(k, w, capitals, profits));
    }
}
