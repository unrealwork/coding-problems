package com.leetcode.backtracking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

class CombinationsTest {

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(4, 2, asList(
                        asList(1, 2),
                        asList(1, 3),
                        asList(1, 4),
                        asList(2, 3),
                        asList(2, 4),
                        asList(3, 4)
                ))
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testCombine(int n, int k, List<List<Integer>> expected) {
        List<List<Integer>> list = Combinations.combine(n, k);
        Assertions.assertEquals(expected, list);
    }
}
