package com.leetcode.tree;

import com.leetcode.array.IntArrayConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeWithFactorsTest {
    @ParameterizedTest
    @CsvSource( {
            "'2,4',3",
            "'2,4,5,10',7"
    })
    void testNumFactoredBinaryTrees(@ConvertWith(IntArrayConverter.class) int[] nums, int expected) {
        assertEquals(expected, BinaryTreeWithFactors.numFactoredBinaryTrees(nums));
    }

}
