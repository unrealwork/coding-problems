package com.leetcode.tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static com.leetcode.tree.BalancedBinaryTree.isBalanced;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BalancedBinaryTreeTest {

    @ParameterizedTest
    @CsvSource( {
            "'1',true",
            "'3,9,20,null,null,15,7',true",
            "'1,2,2,3,3,null,null,4,4',false",
            "'1,null,2,null,3',false"
    })
    void testIsBalanced(@ConvertWith(TreeNodeConverter.class) TreeNode root, boolean expected) {
        assertEquals(expected, isBalanced(root));
    }
}
