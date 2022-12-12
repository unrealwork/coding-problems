package com.leetcode.tree;

import com.leetcode.array.IntArrayConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeToInformEmployesTest {

    @ParameterizedTest
    @CsvSource( {
            "1,0,'-1','0',0",
            "6,2,'2,2,-1,2,2,2','0,0,1,0,0,0',1"
    })
    void testNumOfMinutes(int n, int headId, @ConvertWith(IntArrayConverter.class) int[] managers,
                          @ConvertWith(IntArrayConverter.class) int[] infoTime, int expected) {
        int actual = TimeToInformEmployes.numOfMinutes(n, headId, managers, infoTime);
        assertEquals(expected, actual);
    }
}
