package com.leetcode.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PossibleRotatedMatrixTest {

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[][] {
                                {0, 0, 0}, {0, 1, 0}, {1, 1, 1}
                        },
                        new int[][] {
                                {1, 1, 1}, {0, 1, 0}, {0, 0, 0}
                        },
                        true
                ),
                Arguments.of(
                        new int[][] {
                                {0, 1}, {1, 1}
                        },
                        new int[][] {
                                {1, 0}, {0, 1}
                        },
                        false
                ),
                Arguments.of(new int[][] {
                                {0, 0}, {0, 1}
                        },
                        new int[][] {
                                {0, 0}, {1, 0}
                        },
                        true
                ),
                Arguments.of(new int[][] {
                                {1, 0, 0}, {0, 0, 0}, {0, 0, 0}
                        },
                        new int[][] {
                                {0, 0, 0}, {0, 0, 0}, {0, 0, 1}
                        },
                        true
                )
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void findRotation(int[][] mat, int[][] target, boolean expected) {
        boolean actual = PossibleRotatedMatrix.findRotation(mat, target);
        assertEquals(expected, actual);
    }
}
