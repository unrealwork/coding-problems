package com.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class StringArrayEqualsTest {

    public static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new String[] {"abc", "d", "defg"}, new String[] {"abcddefg"}, true),
                Arguments.of(new String[] {"a", "cb"}, new String[] {"ab", "c"}, false),
                Arguments.of(new String[] {"ab", "c"}, new String[] {"a", "bc"}, true)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testArrayStringsAreEqual(String[] word1, String[] word2, boolean expected) {
        final boolean actual = StringArrayEquals.arrayStringsAreEqual(word1, word2);
        Assertions.assertEquals(expected, actual);
    }
}
