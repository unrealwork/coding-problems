package com.leetcode.backtracking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static com.leetcode.backtracking.MaximumLengthConcatenatedString.maxLength;
import static java.util.Arrays.asList;

class MaximumLengthConcatenatedStringTest {

    public static List<Arguments> testCases() {
        return asList(
                Arguments.of(asList("aa", "bb"), 0),
                Arguments.of(asList("un", "iq", "ue"), 4),
                Arguments.of(asList("cha", "r", "act", "ers"), 6),
                Arguments.of(asList("abcdefghijklmnopqrstuvwxyz"), 26)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testMaxLength(List<String> strings, final int expected) {
        Assertions.assertEquals(expected, maxLength(strings));
    }
}
