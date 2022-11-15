package com.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class NearestValidPointTest {

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.arguments(3, 4, new int[][] {{1, 2}, {3, 1}, {2, 4}, {2, 3}, {4, 4}}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void nearestValidPoint(int x, int y, int[][] points, int expected) {
        Assertions.assertEquals(expected, NearestValidPoint.nearestValidPoint(x, y, points));
    }
}
