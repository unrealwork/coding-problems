package com.leetcode.tree;

import com.leetcode.array.TwoDimIntArrayConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class PathSumIITest {

    private static List<List<Integer>> twoDimArrayAsList(int[][] expected) {
        return Arrays.stream(expected)
                .map(nums -> Arrays.stream(nums).boxed()
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    @ParameterizedTest
    @CsvSource( {
            "'5,4,8,11,null,13,4,7,2,null,null,5,1',22,'5,4,11,2|5,8,4,5'",
            "'',0,''"
    })
    void testPathSum(@ConvertWith(TreeNodeConverter.class) TreeNode tree, int target,
                     @ConvertWith(TwoDimIntArrayConverter.class) int[]... expected) {
        List<List<Integer>> expectedList = twoDimArrayAsList(expected);
        List<List<Integer>> actual = PathSumII.pathSum(tree, target);
        Assertions.assertEquals(expectedList, actual);
    }
}
