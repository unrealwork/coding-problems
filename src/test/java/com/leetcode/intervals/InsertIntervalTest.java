package com.leetcode.intervals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class InsertIntervalTest {

    static Stream<Arguments> testCases() {
        return Stream.of(Arguments.of(new int[][] {
                                {1, 3}, {6, 9}
                        },
                        new int[] {2, 5},
                        new int[][] {
                                {1, 5}, {6, 9}
                        })

        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testInsert(int[][] intervals, int[] newInterval, int[][] expected) {
        int[][] actual = InsertInterval.insert(intervals, newInterval);
        assertArrayEquals(expected, actual);
    }
}
