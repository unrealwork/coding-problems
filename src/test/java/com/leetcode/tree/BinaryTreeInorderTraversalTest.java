package com.leetcode.tree;

import com.leetcode.list.IntListConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class BinaryTreeInorderTraversalTest {
    @ParameterizedTest
    @CsvSource( {"'1,null,2,3', '1,3,2'", "'', ''", "'1', '1'"})
    void test(final @ConvertWith(TreeNodeConverter.class) TreeNode tree,
              final @ConvertWith(IntListConverter.class) List<Integer> expectedOrder) {
        final List<Integer> actualOrder = BinaryTreeInorderTraversal.inorderTraversal(tree);
        Assertions.assertEquals(expectedOrder, actualOrder);
    }
}
