package com.leetcode.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class NearestExitTest {

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new char[][] {
                        {'+', '+', '.', '+'},
                        {'.', '.', '.', '+'},
                        {'+', '+', '+', '.'}
                }, new int[] {1, 2}, 1),
                Arguments.of(new char[][] {
                        {'.', '+'}
                }, new int[] {0, 0}, -1),
                Arguments.of(new char[][] {
                        {'+', '+', '+'},
                        {'.', '.', '.'},
                        {'+', '+', '+'}
                }, new int[] {1, 0}, 2)

        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testNearestExit(char[][] maze, int[] entrance, int expected) {
        int actual = NearestExit.nearestExit(maze, entrance);
        Assertions.assertEquals(expected, actual);
    }
}
