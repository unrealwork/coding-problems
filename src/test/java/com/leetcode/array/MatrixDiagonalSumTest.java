package com.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MatrixDiagonalSumTest {

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[][] {{1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}}, 25)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testDiagonalSum(int[][] mat, int expected) {
        int actual = MatrixDiagonalSum.diagonalSum(mat);
        Assertions.assertEquals(expected, actual);
    }
}
