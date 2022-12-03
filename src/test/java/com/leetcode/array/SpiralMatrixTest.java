package com.leetcode.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpiralMatrixTest {

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[][] {{1}}, List.of(1)),
                Arguments.of(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
                        List.of(1, 2, 3, 6, 9, 8, 7, 4, 5)),
                Arguments.of(new int[][] {
                        {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}
                }, List.of(1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10)),
                Arguments.of(new int[][] {
                        {2, 3, 4}, {5, 6, 7}, {8, 9, 10}, {11, 12, 13}
                }, List.of(2, 3, 4, 7, 10, 13, 12, 11, 8, 5, 6, 9))
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testSpiralOrder(int[][] matrix, List<Integer> expected) {
        assertEquals(expected, SpiralMatrix.spiralOrder(matrix));
    }
}
