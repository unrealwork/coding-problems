package com.leetcode.tree;

import com.leetcode.array.StringArrayConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Set;

final class BinaryTreePathsTest {

    @ParameterizedTest
    @CsvSource( {
            "'1,2,3','1->2,1->3'",
            "'1,2,null','1->2'",
            "'',''"
    })
    void testBinaryTreePaths(@ConvertWith(TreeNodeConverter.class) TreeNode treeNode,
                             @ConvertWith(StringArrayConverter.class) String[] expected) {
        Set<String> expectedList = Set.of(expected);
        List<String> actual = BinaryTreePaths.binaryTreePaths(treeNode);
        Assertions.assertEquals(expectedList, Set.copyOf(actual));
    }
}
