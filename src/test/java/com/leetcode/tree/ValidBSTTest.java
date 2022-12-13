package com.leetcode.tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidBSTTest {

    @ParameterizedTest
    @CsvSource( {
            "'2,1,3',true",
            "'1,2,3',false"
    })
    void testIsValidBST(@ConvertWith(TreeNodeConverter.class) TreeNode root, boolean expected) {
        assertEquals(expected, ValidBST.isValidBST(root));
    }
}
