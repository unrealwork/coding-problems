package com.leetcode.tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RangeSumBSTTest {

    @ParameterizedTest
    @CsvSource( {
            "'10,5,15,3,7,null,18',7,15,32",
            "'10,5,15,3,7,13,18,1,null,6',6,10,23"
    })
    void rangeSumBST(@ConvertWith(TreeNodeConverter.class) TreeNode root, int low, int high, int expected) {
        assertEquals(expected, RangeSumBST.rangeSumBST(root, low, high));
    }
}
