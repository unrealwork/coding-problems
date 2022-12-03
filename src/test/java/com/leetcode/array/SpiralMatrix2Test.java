package com.leetcode.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SpiralMatrix2Test {

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(3, new int[][] {
                        {1, 2, 3}, {8, 9, 4}, {7, 6, 5}
                })
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void generateMatrix(int n, int[][] expected) {
        assertArrayEquals(expected, SpiralMatrix2.generateMatrix(n));
    }
}
