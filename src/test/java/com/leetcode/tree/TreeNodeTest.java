package com.leetcode.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class TreeNodeTest {

    @ParameterizedTest
    @CsvSource( {
            "'1','', false",
            "'1,2,3','1,2,3', true",
            "'1,2,null','1,2,3', false"
    })
    void testEquals(@ConvertWith(TreeNodeConverter.class) TreeNode p, @ConvertWith(TreeNodeConverter.class) TreeNode q, boolean expected) {
        Assertions.assertEquals(expected, p.equals(q));
    }

    @ParameterizedTest
    @CsvSource( {
            "'1,2,3','1,2,3', true",
            "'1,2,null','1,2,3', false"
    })
    void testHashCode(@ConvertWith(TreeNodeConverter.class) TreeNode p, @ConvertWith(TreeNodeConverter.class) TreeNode q, boolean expected) {
        boolean isHashCodesEqual = p.hashCode() == q.hashCode();
        Assertions.assertEquals(expected, isHashCodesEqual);
    }

    @Test
    void testDiffClassEquals() {
        Assertions.assertNotEquals("", new TreeNode(1));
    }
}
