package com.leetcode.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class StraightLineTest {

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[][] {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}, true),
                Arguments.of(new int[][] {{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}}, false),
                Arguments.of(new int[][] {{0, -1}, {0, 0}, {0, 1}}, true)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testCheckStraightLine(int[][] coords, boolean expected) {
        Assertions.assertEquals(expected, StraightLine.checkStraightLine(coords));
    }
}
