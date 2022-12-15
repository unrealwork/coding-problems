package com.leetcode.tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

final class CodecTest {
    private final Codec codec = new Codec();

    @ParameterizedTest
    @CsvSource( {
            "'[1,2,3,null,null,4,5]'",
            "'[1,2,3,null,null,4,5,6,7]'",
            "'[4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2]'",
            "'[]'"
    })
    void test(String treeString) {
        TreeNode root = codec.deserialize(treeString);
        String s = codec.serialize(root);
        TreeNode des = codec.deserialize(s);
        assertTrue(SameTree.isSameTree(root, des));
    }
}
