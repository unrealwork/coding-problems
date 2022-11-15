package com.leetcode.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class CountCompleteNodesTest {

    @ParameterizedTest
    @CsvSource( {
            "'1,2,3,4,5,6',6",
            "'1,2,3,4,5,6,7',7",
            "'1,2,3,4,5',5",
            "'1,2,3,4',4",
            "'', 0",
            "'1',1"
    })
    void testCountNodes(@ConvertWith(TreeNodeConverter.class) TreeNode root, int expected) {
        Assertions.assertEquals(expected, CountCompleteNodes.countNodes(root));
    }
}
