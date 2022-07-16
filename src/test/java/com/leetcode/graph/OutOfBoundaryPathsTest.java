package com.leetcode.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class OutOfBoundaryPathsTest {

    @MethodSource
    static Stream<Arguments> testData() {
        return Stream.of(
                arguments(1, 3, 3, 0, 1, 12),
                arguments(2, 2, 2, 0, 0, 6),
                arguments(8, 50, 23, 5, 26, 914783380)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void findPaths(int m, int n, int maxMove, int startRow, int startColumn, int expected) {
        final int actual = OutOfBoundaryPaths.findPaths(m, n, maxMove, startRow, startColumn);
        Assertions.assertEquals(expected, actual);
    }
}
