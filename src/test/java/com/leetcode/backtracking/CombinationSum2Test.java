package com.leetcode.backtracking;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CombinationSum2Test {

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[] {10, 1, 2, 7, 6, 1, 5}, 8,
                        Set.of(asList(1, 1, 6),
                                asList(1, 2, 5),
                                asList(1, 7),
                                asList(2, 6))
                ),
                Arguments.of(new int[] {2, 5, 2, 1, 2}, 5,
                        Set.of(
                                asList(1, 2, 2),
                                List.of(5)
                        ))
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void combinationSum2(int[] candidates, int target, Set<List<Integer>> expected) {
        List<List<Integer>> actual = CombinationSum2.combinationSum2(candidates, target);
        assertEquals(expected.size(), actual.size());
        Set<List<Integer>> expectedSet = Set.copyOf(actual);
        assertEquals(expected, expectedSet);
    }
}
