package com.leetcode.tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxDiffBetweenAncestorsTest {

    @ParameterizedTest
    @CsvSource( {
            "'8,3,10,1,6,null,14,null,null,4,7,13',7",
            "'1,null,2,null,0,3',3"
    })
    void testMaxAncestorDiff(@ConvertWith(TreeNodeConverter.class) TreeNode treeNode, int expected) {
        assertEquals(expected, MaxDiffBetweenAncestors.maxAncestorDiff(treeNode));
    }
}
