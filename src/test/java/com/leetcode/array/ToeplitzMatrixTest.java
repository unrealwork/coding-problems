package com.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ToeplitzMatrixTest {

    public static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[][] {
                                {1, 2, 3, 4},
                                {5, 1, 2, 3},
                                {9, 5, 1, 2}
                        },
                        true
                ),
                Arguments.of(new int[][] {
                        {1, 2},
                        {2, 2}
                }, false),
                Arguments.of(new int[][] {{1, 2, 3}},
                        true),
                Arguments.of(new int[][] {{1}, {2}, {3}},
                        true)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testIsToeplitzMatrix(int[][] matrix, boolean expected) {
        Assertions.assertEquals(expected, ToeplitzMatrix.isToeplitzMatrix(matrix));
    }
}
