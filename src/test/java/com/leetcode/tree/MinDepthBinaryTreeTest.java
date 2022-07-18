package com.leetcode.tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinDepthBinaryTreeTest {

    @ParameterizedTest
    @CsvSource( {
            "'',0",
            "'3,9,20,null,null,15,7',2",
            "'2,null,3,null,4,null,5,null,6',5"
    })
    void testMinDepth(@ConvertWith(TreeNodeConverter.class) TreeNode node, int expected) {
        int actual = MinDepthBinaryTree.minDepth(node);
        assertEquals(expected, actual);
    }
}
