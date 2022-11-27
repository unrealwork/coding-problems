package com.leetcode.tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TwoSum4Test {

    @ParameterizedTest
    @CsvSource( {
            "'',1,false",
            "'5,3,6,2,4,null,7',28,false",
            "'5,3,6,2,4,null,7',9,true"
    })
    void testFindTarget(@ConvertWith(TreeNodeConverter.class) TreeNode treeNode, int target,
                        boolean expected) {
        assertEquals(expected, TwoSum4.findTarget(treeNode, target));
    }
}
