package com.leetcode.tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertSame;

class LowestCommonAncestorTest {

    private static TreeNode findByValue(TreeNode root, int value) {
        if (root != null) {
            if (root.val == value) {
                return root;
            }
            TreeNode leftNodeRes = findByValue(root.left, value);
            if (leftNodeRes != null) {
                return leftNodeRes;
            }
            return findByValue(root.right, value);
        }
        return null;
    }

    @ParameterizedTest
    @CsvSource( {
            "'3,5,1,6,2,0,8,null,null,7,4',5,1,3",
            "'3,5,1,6,2,0,8,null,null,7,4',5,4,5",
    })
    void testLowestCommonAncestor(@ConvertWith(TreeNodeConverter.class) TreeNode root, int pValue,
                                  int qValue, int expectedValue) {
        final TreeNode p = findByValue(root, pValue);
        final TreeNode q = findByValue(root, qValue);
        final TreeNode expected = findByValue(root, expectedValue);
        final TreeNode actual = LowestCommonAncestor.lowestCommonAncestor(root, p, q);
        assertSame(expected, actual);
    }
}
