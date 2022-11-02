package com.leetcode.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MinimumGeneticMutationTest {

    public static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("AACCGGTT", "AACCGGTA", new String[] {"AACCGGTA"}, 1),
                Arguments.of("AACCGGTT", "AAACGGTA", new String[] {"AACCGGTA", "AACCGCTA", "AAACGGTA"}, 2),
                Arguments.of("AAAAACCC", "AACCCCCC", new String[] {"AAAACCCC", "AAACCCCC", "AACCCCCC"}, 3),
                Arguments.of("AACCGGTT", "AACCAGTA", new String[] {"AACCGGTA"}, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void minMutation(String start, String end, String[] bank, int expected) {
        int actual = MinimumGeneticMutation.minMutation(start, end, bank);
        Assertions.assertEquals(expected, actual);
    }
}
