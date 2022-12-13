package com.leetcode.tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZigZagOrderTest {
    private static TreeNodeConverter converter = new TreeNodeConverter();

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(treeNode("3,9,20,null,null,15,7"),
                        List.of(
                                List.of(3),
                                List.of(20, 9),
                                List.of(15, 7)
                        )
                ),
                Arguments.of(treeNode("1"),
                        List.of(List.of(1))
                ),

                Arguments.of(treeNode(""),
                        List.of()
                )
        );
    }

    private static TreeNode treeNode(String treeString) {
        return (TreeNode) converter.convert(treeString, null);
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testZigzagLevelOrder(TreeNode root, List<List<Integer>> expected) {
        List<List<Integer>> actual = ZigZagOrder.zigzagLevelOrder(root);
        assertEquals(expected, actual);
    }
}
