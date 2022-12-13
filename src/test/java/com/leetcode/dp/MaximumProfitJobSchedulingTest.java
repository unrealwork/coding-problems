package com.leetcode.dp;

import com.leetcode.array.IntArrayConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumProfitJobSchedulingTest {

    @ParameterizedTest
    @CsvSource( {
            "'1,2,3,3','3,4,5,6','50,10,40,70',120",
            "'1,2,3,4,6','3,5,10,6,9','20,20,100,70,60',150",
            "'1,1,1','2,3,4','5,6,4',6",
            "'4,2,4,8,2','5,5,5,10,8','1,2,8,10,4',18",
            "'43,13,36,31,40,5,47,13,28,16,2,11','44,22,41,41,47,13,48,35,48,26,21,39','8,20,3,19,16,8,11,13,2,15,1,1',66",
            "'6,24,45,27,13,43,47,36,14,11,11,12','31,27,48,46,44,46,50,49,24,42,13,27','14,4,16,12,20,3,18,6,9,1,2,8',45"
    })
    void testJobScheduling(@ConvertWith(IntArrayConverter.class) int[] start,
                           @ConvertWith(IntArrayConverter.class) int[] end,
                           @ConvertWith(IntArrayConverter.class) int[] profit, int expected) {
        int actual = MaximumProfitJobScheduling.jobScheduling(start, end, profit);
        assertEquals(expected, actual);
    }
}
