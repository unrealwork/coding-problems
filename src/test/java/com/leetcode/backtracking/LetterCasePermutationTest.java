package com.leetcode.backtracking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

class LetterCasePermutationTest {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("a1b2", Set.of("a1b2", "a1B2", "A1b2", "A1B2")),
                Arguments.of("c", Set.of("c", "C")),
                Arguments.of("C", Set.of("c", "C"))
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testLetterCasePermutation(String s, Set<String> expected) {
        List<String> actual = LetterCasePermutation.letterCasePermutation(s);
        Assertions.assertEquals(expected, Set.copyOf(actual));
    }
}
