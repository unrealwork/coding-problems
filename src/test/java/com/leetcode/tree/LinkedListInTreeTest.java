package com.leetcode.tree;

import com.leetcode.list.ListNode;
import com.leetcode.list.ListNodeConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedListInTreeTest {

    @ParameterizedTest
    @CsvSource( {
            "'4,2,8', '1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3', true",
            "'1,4,2,6', '1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3', true",
            "'1,4,2,6,8', '1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3', false",
            "'1,10', '1,null,1,10,1,9', true",
            "'2,2,1','2,null,2,null,2,null,1', true"
    })
    void testIsSubPath(@ConvertWith(ListNodeConverter.class) ListNode list,
                       @ConvertWith(TreeNodeConverter.class) TreeNode root,
                       boolean expected) {
        assertEquals(expected, LinkedListInTree.isSubPath(list, root));
    }
}
