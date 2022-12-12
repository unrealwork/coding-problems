package com.leetcode.graph;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("checkstyle:RegexpSingleline")
class NumberOfProvincesTest {

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(
                        new int[][] {
                                {1, 1, 0}, {1, 1, 0}, {0, 0, 1}
                        }, 2
                )
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testFindCircleNum(int[][] graph, int expected) {
        int actual = NumberOfProvinces.findCircleNum(graph);
        assertEquals(expected, actual);
    }
}
