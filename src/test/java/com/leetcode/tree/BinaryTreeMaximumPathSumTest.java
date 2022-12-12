package com.leetcode.tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeMaximumPathSumTest {

    @ParameterizedTest
    @CsvSource( {
            "'1,2,3',6",
            "'-10,9,20,null,null,15,7',42"
    })
    void testMaxPathSum(@ConvertWith(TreeNodeConverter.class) TreeNode root, int expected) {
        int actual = BinaryTreeMaximumPathSum.maxPathSum(root);
        assertEquals(expected, actual);
    }
}
