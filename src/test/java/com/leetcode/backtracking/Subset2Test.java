package com.leetcode.backtracking;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Subset2Test {

    static Stream<Arguments> testCases() {
        return Stream.of(Arguments.of(new int[] {1, 2, 2}, List.of(
                List.of(),
                List.of(1),
                List.of(1, 2),
                List.of(1, 2, 2),
                List.of(2),
                List.of(2, 2)
        )));
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testSubsetsWithDup(int[] nums, List<List<Integer>> expected) {
        assertEquals(expected, Subset2.subsetsWithDup(nums));
    }
}
