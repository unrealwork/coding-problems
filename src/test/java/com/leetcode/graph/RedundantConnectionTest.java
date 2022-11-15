package com.leetcode.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RedundantConnectionTest {

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[][] {{1, 2}, {1, 3}, {2, 3}}, new int[] {2, 3}),
                Arguments.of(new int[][] {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}}, new int[] {1, 4}),
                Arguments.of(new int[][] {{1, 4}, {3, 4}, {1, 3}, {1, 2}, {4, 5}}, new int[] {1, 3}),
                Arguments.of(new int[][] {{3, 4}, {1, 2}, {2, 4}, {3, 5}, {2, 5}}, new int[] {2, 5}),
                Arguments.of(new int[][] {{1, 5}, {3, 4}, {3, 5}, {4, 5}, {2, 4}}, new int[] {4, 5})
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testFindRedundantConnection(int[][] graph, int[] expected) {
        Assertions.assertArrayEquals(expected, RedundantConnection.findRedundantConnection(graph));
    }
}
