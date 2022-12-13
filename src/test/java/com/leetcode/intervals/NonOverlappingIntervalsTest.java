package com.leetcode.intervals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NonOverlappingIntervalsTest {

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[][] {{1, 2}, {2, 3}, {3, 4}, {1, 3}}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testEraseOverlapIntervals(int[][] arr, int expected) {
        int actual = NonOverlappingIntervals.eraseOverlapIntervals(arr);
        assertEquals(expected, actual);
    }
}
