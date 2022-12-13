package com.leetcode.graph;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShortestBinaryPathTest {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[][] {
                        {0, 1}, {1, 0}
                }, 2),
                Arguments.of(new int[][] {
                        {0, 0, 0}, {1, 1, 0}, {1, 1, 0}
                }, 4),
                Arguments.of(new int[][] {
                        {1, 0, 0}, {1, 1, 0}, {1, 1, 0}
                }, -1),
                Arguments.of(new int[][] {
                        {0, 0, 0}, {1, 1, 0}, {1, 1, 1}
                }, -1),
                Arguments.of(new int[][] {
                        {0, 0, 0}, {0, 0, 0}, {0, 0, 0}
                }, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testShortestPathBinaryMatrix(int[][] grid, int expected) {
        int actual = ShortestBinaryPath.shortestPathBinaryMatrix(grid);
        assertEquals(expected, actual);
    }
}
