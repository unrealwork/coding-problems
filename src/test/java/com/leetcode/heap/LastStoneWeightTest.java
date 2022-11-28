package com.leetcode.heap;

import com.leetcode.array.IntArrayConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LastStoneWeightTest {

    @ParameterizedTest
    @CsvSource( {
            "'2,7,4,1,8,1',1",
            "'2,2',0"
    })
    void testLastStoneWeight(@ConvertWith(IntArrayConverter.class) int[] stones, int expected) {
        assertEquals(expected, LastStoneWeight.lastStoneWeight(stones));
    }
}
