package com.leetcode.impl;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BallFallTest {

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(
                        new int[][] {
                                {1, 1, 1, -1, -1},
                                {1, 1, 1, -1, -1},
                                {-1, -1, -1, 1, 1},
                                {1, 1, 1, 1, -1},
                                {-1, -1, -1, -1, -1}
                        },
                        new int[] {1, -1, -1, -1, -1}
                ),
                Arguments.of(new int[][] {
                                {1, 1, 1, 1, 1, 1},
                                {-1, -1, -1, -1, -1, -1},
                                {1, 1, 1, 1, 1, 1},
                                {-1, -1, -1, -1, -1, -1}
                        },
                        new int[] {0, 1, 2, 3, 4, -1}
                )
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testFindBall(int[][] grid, int[] expected) {
        int[] actual = BallFall.findBall(grid);
        assertArrayEquals(expected, actual);
    }
}
