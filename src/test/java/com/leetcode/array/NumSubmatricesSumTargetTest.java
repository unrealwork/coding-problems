package com.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class NumSubmatricesSumTargetTest {

    public static Stream<Arguments> targetCountData() {
        return Stream.of(
                Arguments.arguments(new int[][] {
                                {0, 1, 0},
                                {1, 1, 1},
                                {0, 1, 0}},
                        0, 4),
                Arguments.arguments(new int[][] {
                                {0, 1, 0},
                                {1, 1, 1},
                                {0, 1, 0}},
                        3, 6)
        );
    }

    public static Stream<Arguments> prefixSumTestData() {
        return Stream.of(
                Arguments.arguments(
                        new int[][] {
                                {0, 1},
                                {2, 3}
                        }, new int[][] {
                                {0, 1},
                                {2, 6}
                        }),
                Arguments.arguments(
                        new int[][] {
                                {0, 1, 0},
                                {1, 1, 1},
                                {0, 1, 0}
                        }, new int[][] {
                                {0, 1, 1},
                                {1, 3, 4},
                                {1, 4, 5}
                        })
        );
    }

    public static Stream<Arguments> matrixSumData() {
        return Stream.of(
                Arguments.arguments(new int[][] {
                        {0, 1, 1},
                        {1, 3, 4},
                        {1, 4, 5}
                }, 0, 0, 0, 0, 0),
                Arguments.arguments(new int[][] {
                        {0, 1, 1},
                        {1, 3, 4},
                        {1, 4, 5}
                }, 0, 0, 1, 1, 3),
                Arguments.arguments(new int[][] {
                        {0, 1, 1},
                        {1, 3, 4},
                        {1, 4, 5}
                }, 1, 1, 2, 2, 3),
                Arguments.arguments(new int[][] {
                        {0, 1, 1},
                        {1, 3, 4},
                        {1, 4, 5}
                }, 1, 0, 2, 1, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("targetCountData")
    void testNumSubmatrixSumTarget(int[][] matrix, int target, int expected) {
        Assertions.assertEquals(expected,
                NumSubmatricesSumTarget.numSubmatrixSumTarget(matrix, target));
    }

    @ParameterizedTest
    @MethodSource("prefixSumTestData")
    void prefixSumMatrix(int[][] m, int[][] expected) {
        int[][] p = NumSubmatricesSumTarget.prefixSumMatrix(m);
        Assertions.assertArrayEquals(expected, p);
    }

    @ParameterizedTest
    @MethodSource("matrixSumData")
    void testGetMatrixSum(int[][] p, int x1, int y1, int x2, int y2, int expected) {
        final int sum = NumSubmatricesSumTarget.getMatrixSum(x1, y1, x2, y2, p);
        Assertions.assertEquals(expected, sum);
    }
}
