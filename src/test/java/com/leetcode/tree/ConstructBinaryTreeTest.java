package com.leetcode.tree;

import com.leetcode.array.IntArrayConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConstructBinaryTreeTest {

    @ParameterizedTest
    @CsvSource( {
            "'', '', ''",
            "'3', '3', '3'",
            "'3,9,20,15,7', '9,3,15,20,7', '3,9,20,null,null,15,7'"
    })
    @DisplayName("buildTree should construct correct binary tree")
    void buildTree(@ConvertWith(IntArrayConverter.class) int[] preorder,
                   @ConvertWith(IntArrayConverter.class) int[] inorder,
                   @ConvertWith(TreeNodeConverter.class) TreeNode node) {
        TreeNode res = ConstructBinaryTree.buildTree(preorder, inorder);
        assertEquals(res, node);
    }
}
