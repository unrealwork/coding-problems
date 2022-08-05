package com.leetcode.backtracking;

import com.leetcode.array.IntArrayConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CombinationSumIVTest {

    @ParameterizedTest
    @CsvSource( {
            "'1,2,3',4,7",
            "'9',3,0",
            "'2,1,3',35,1132436852"
    })
    void testCombinationSum4(@ConvertWith(IntArrayConverter.class) int[] nums, int target,
                             int expected) {
        int actual = CombinationSumIV.combinationSum4(nums, target);
        assertEquals(expected, actual);
    }
}
