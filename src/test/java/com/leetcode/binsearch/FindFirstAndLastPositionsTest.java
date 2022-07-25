package com.leetcode.binsearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FindFirstAndLastPositionsTest {

    public static Stream<Arguments> testData() {
        return Stream.of(
                arguments(new int[] {5, 7, 7, 8, 8, 10}, 8,
                        new int[] {3, 4}),
                arguments(new int[] {5, 7, 7, 8, 8, 10}, 6,
                        new int[] {-1, -1}),
                arguments(new int[] {5, 7, 7, 8, 8, 8, 8, 10}, 8,
                        new int[] {3, 6}),
                arguments(new int[] {}, 0,
                        new int[] {-1, -1}),
                arguments(new int[] {5, 7, 7, 8, 8, 10}, 10,
                        new int[] {5, 5}),
                arguments(new int[] {5, 7, 7, 8, 8, 10}, 5,
                        new int[] {0, 0}),
                arguments(new int[] {1}, 1, new int[] {0, 0})
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testSearchRange(int[] nums, int target, int[] expected) {
        int[] actual = FindFirstAndLastPositions.searchRange(nums, target);
        assertArrayEquals(expected, actual);
    }
}
