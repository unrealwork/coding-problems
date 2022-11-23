package com.leetcode.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class SumOfLeftLeavesTest {

    @ParameterizedTest
    @CsvSource( {
            "'3,9,20,null,null,15,7',24"
    })
    void testSumOfLeftLeaves(@ConvertWith(TreeNodeConverter.class) TreeNode root, int expected) {
        int actual = SumOfLeftLeaves.sumOfLeftLeaves(root);
        Assertions.assertEquals(expected, actual);
    }
}
