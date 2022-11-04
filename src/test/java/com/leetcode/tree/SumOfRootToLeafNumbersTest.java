package com.leetcode.tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumOfRootToLeafNumbersTest {

    @ParameterizedTest
    @CsvSource( {
            "'1,2,3', 25",
            "'4,9,0,5,1', 1026"
    })
    void testSumNumbers(@ConvertWith(TreeNodeConverter.class) TreeNode treeNode, int expected) {
        assertEquals(expected, SumOfRootToLeafNumbers.sumNumbers(treeNode));
    }
}
