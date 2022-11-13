package com.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ReverseWordsStringTest {

    @ParameterizedTest
    @CsvSource( {
            "'the sky is blue', 'blue is sky the'",
            "'  hello world  ', 'world hello'",
            "'a good   example', 'example good a'"
    })
    void testReverseWords(String s, String expected) {
        Assertions.assertEquals(expected, ReverseWordsString.reverseWords(s));
    }
}
