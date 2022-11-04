package com.leetcode.twopointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ReverseVowelsTest {

    @ParameterizedTest
    @CsvSource( {
            "hello, holle",
            "leetcode, leotcede",
            "abde, ebda",
            "abcde, ebcda",
            "Aa, aA"
    })
    void reverseVowels(String word, String expected) {
        Assertions.assertEquals(expected, ReverseVowels.reverseVowels(word));
    }

    @ParameterizedTest
    @CsvSource( {
            "a, true",
            "b, false"
    })
    void testIsVowel(final char c, final boolean expected) {
        Assertions.assertEquals(expected, ReverseVowels.isVowel(c));
    }
}
