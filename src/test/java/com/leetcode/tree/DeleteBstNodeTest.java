package com.leetcode.tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DeleteBstNodeTest {

    @ParameterizedTest
    @CsvSource( {
            "'5,3,6,2,4,null,7',0",
            "'5,3,6,2,4,null,7',3",
            "'',4",
            "'4,3',4",
            "'5,3,7,2,4,6,8',6",
            "'5,3,7,2,4,6,8',5",
            "'5,3,7,2,4,6,8',7",
            "'5,3,6,2,4,null,7',5"
    })
    void testDeleteNode(final @ConvertWith(TreeNodeConverter.class) TreeNode root, int key) {
        Set<Integer> set = setOfValues(root);
        TreeNode r = DeleteBstNode.deleteNode(root, key);
        Set<Integer> setAfterRemove = setOfValues(r);
        assertTrue(ValidBST.isValidBST(r));
        assertNull(SearchBST.searchBST(r, key));
        assertTrue(containsAllExceptRemoved(key, set, setAfterRemove));
    }

    private boolean containsAllExceptRemoved(int key, Set<Integer> set, Set<Integer> setAfterRemove) {
        for (Integer v : set) {
            if (v != key && !setAfterRemove.contains(v)) {
                return false;
            }
        }
        return true;
    }

    private Set<Integer> setOfValues(TreeNode root) {
        return Set.copyOf(BinaryTreeInorderTraversal.inorderTraversal(root));
    }
}
