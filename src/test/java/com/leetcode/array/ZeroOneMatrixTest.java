package com.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ZeroOneMatrixTest {

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(
                        new int[][] {
                                {0, 0, 0},
                                {0, 1, 0},
                                {1, 1, 1}
                        },
                        new int[][] {
                                {0, 0, 0},
                                {0, 1, 0},
                                {1, 2, 1}
                        }
                )
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testUpdateMatrix(final int[][] mat, final int[][] expected) {
        int[][] actual = ZeroOneMatrix.updateMatrix(mat);
        Assertions.assertArrayEquals(expected, actual);
    }
}
