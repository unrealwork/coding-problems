package com.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.leetcode.array.KthSmallestInSortedMatrix.kthSmallest;

class KthSmallestInSortedMatrixTest {

    public static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.arguments(new int[][] {
                        {1, 5, 9},
                        {10, 11, 13},
                        {12, 13, 15}
                }, 8, 13)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testKthSmallest(int[][] matrix, int k, int expected) {
        Assertions.assertEquals(expected, kthSmallest(matrix, k));
    }
}
