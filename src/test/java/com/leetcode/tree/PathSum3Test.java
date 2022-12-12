package com.leetcode.tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PathSum3Test {

    @ParameterizedTest
    @CsvSource( {
            "'10,5,-3,3,2,null,11,3,-2,null,1',8,3",
            "'5,4,8,11,null,13,4,7,2,null,null,5,1',22,3"
    })
    void testPathSum(@ConvertWith(TreeNodeConverter.class) TreeNode root, int target, int expected) {
        assertEquals(expected, PathSum3.pathSum(root, target));
    }
}
