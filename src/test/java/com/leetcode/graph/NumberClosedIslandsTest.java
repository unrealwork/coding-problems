package com.leetcode.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class NumberClosedIslandsTest {

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[][] {
                        {1, 1, 1, 1, 1, 1, 1, 0},
                        {1, 0, 0, 0, 0, 1, 1, 0},
                        {1, 0, 1, 0, 1, 1, 1, 0},
                        {1, 0, 0, 0, 0, 1, 0, 1},
                        {1, 1, 1, 1, 1, 1, 1, 0}
                }, 2),
                Arguments.of(new int[][] {
                        {0, 0, 1, 0, 0},
                        {0, 1, 0, 1, 0},
                        {0, 1, 1, 1, 0}
                }, 1),
                Arguments.of(new int[][] {
                        {1, 1, 1, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 1},
                        {1, 0, 1, 1, 1, 0, 1},
                        {1, 0, 1, 0, 1, 0, 1},
                        {1, 0, 1, 1, 1, 0, 1},
                        {1, 0, 0, 0, 0, 0, 1},
                        {1, 1, 1, 1, 1, 1, 1}
                }, 2),
                Arguments.of(new int[][] {
                                {0, 0, 1, 1, 0, 1, 0, 0, 1, 0},
                                {1, 1, 0, 1, 1, 0, 1, 1, 1, 0},
                                {1, 0, 1, 1, 1, 0, 0, 1, 1, 0},
                                {0, 1, 1, 0, 0, 0, 0, 1, 0, 1},
                                {0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
                                {0, 1, 0, 1, 0, 1, 0, 1, 1, 1},
                                {1, 0, 1, 0, 1, 1, 0, 0, 0, 1},
                                {1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                                {1, 1, 1, 0, 0, 1, 0, 1, 0, 1},
                                {1, 1, 1, 0, 1, 1, 0, 1, 1, 0}},
                        5)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testClosedIsland(int[][] grid, int expected) {
        Assertions.assertEquals(expected, NumberClosedIslands.closedIsland(grid));
    }
}
