package com.leetcode.tree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

class ConstructBinaryTreeTest {

    @Test
    @DisplayName("Empty traverse should generate empty tree")
    void buildTree() {
        TreeNode res = ConstructBinaryTree.buildTree(new int[] {}, new int[] {});
        assertNull(res);
    }
}
