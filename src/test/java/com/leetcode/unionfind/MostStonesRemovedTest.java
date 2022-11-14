package com.leetcode.unionfind;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MostStonesRemovedTest {

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[][] {}, 0),
                Arguments.of(new int[][] {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}}, 5),
                Arguments.of(new int[][] {{0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}}, 3),
                Arguments.of(new int[][] {{0, 0}}, 0),
                Arguments.of(new int[][] {{0, 1}, {0, 2}, {4, 3}, {2, 4}, {0, 3}, {1, 1}}, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void removeStones(int[][] stones, int expected) {
        Assertions.assertEquals(expected, MostStonesRemoved.removeStones(stones));
    }

}
