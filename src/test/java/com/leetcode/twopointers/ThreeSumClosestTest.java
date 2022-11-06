package com.leetcode.twopointers;

import com.leetcode.array.IntArrayConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class ThreeSumClosestTest {

    @ParameterizedTest
    @CsvSource( {
            "'-1,2,1,-4', 1, 2",
            "'0,0,0',1,0",
            "'-3,-1,1,2',1,0",
            "'1,0,1,1',100,3"
    })
    void testThreeSumClosest(@ConvertWith(IntArrayConverter.class) int[] arr, int target, int expected) {
        int actual = ThreeSumClosest.threeSumClosest(arr, target);
        Assertions.assertEquals(expected, actual);
    }
}
