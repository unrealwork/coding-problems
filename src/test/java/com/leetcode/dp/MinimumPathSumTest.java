package com.leetcode.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MinimumPathSumTest {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[][] {
                        {1, 3, 1},
                        {1, 5, 1},
                        {4, 2, 1}
                }, 7),
                Arguments.of(new int[][] {
                        {1, 2, 3}, {4, 5, 6}
                }, 12)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void tesMinPathSum(int[][] grid, int expected) {
        Assertions.assertEquals(expected, MinimumPathSum.minPathSum(grid));
    }
}
