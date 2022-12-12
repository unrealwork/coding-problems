package com.leetcode.tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxProductOfSplittedBinaryTreeTest {

    @ParameterizedTest
    @CsvSource( {
            "'1,2,3,4,5,6',110"
    })
    void testMaxProduct(@ConvertWith(TreeNodeConverter.class) TreeNode root, int expected) {
        int actual = MaxProductOfSplittedBinaryTree.maxProduct(root);
        assertEquals(expected, actual);
    }
}
