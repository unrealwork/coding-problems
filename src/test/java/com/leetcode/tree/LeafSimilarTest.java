package com.leetcode.tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LeafSimilarTest {

    @ParameterizedTest
    @CsvSource( {
            "'3,5,1,6,2,9,8,null,null,7,4','3,5,1,6,7,4,2,null,null,null,null,null,null,9,8',true",
            "'1,2,3','1,3,2',false"
    })
    void testLeafSimilar(@ConvertWith(TreeNodeConverter.class) TreeNode root1,
                         @ConvertWith(TreeNodeConverter.class) TreeNode root2,
                         boolean expected) {
        boolean actual = LeafSimilar.leafSimilar(root1, root2);
        assertEquals(expected, actual);
    }
}
