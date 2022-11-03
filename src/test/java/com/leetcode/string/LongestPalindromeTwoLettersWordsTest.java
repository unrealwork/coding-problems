package com.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class LongestPalindromeTwoLettersWordsTest {

    public static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new String[] {"lc", "cl", "gg"}, 6),
                Arguments.of(new String[] {"ab", "ty", "yt", "lc", "cl", "ab"}, 8),
                Arguments.of(new String[] {"ab", "ty", "yt", "lc", "cl", "ab"}, 8),
                Arguments.of(new String[] {"cc", "ll", "xx"}, 2),
                Arguments.of(new String[] {"qo", "fo", "fq", "qf", "fo", "ff", "qq", "qf", "of", "of", "oo", "of", "of", "qf", "qf", "of"}, 14),
                Arguments.of(new String[0], 0)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testLongestPalindrome(String[] words, int expected) {
        Assertions.assertEquals(LongestPalindromeTwoLettersWords.longestPalindrome(words), expected);
    }
}
