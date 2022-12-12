package com.leetcode.hashmap;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordPatternTest {

    @ParameterizedTest
    @CsvSource( {
            "'abba','dog cat cat dog', true",
            "'abba','dog cat cat fish', false",
            "'abba','dog dog dog dog', false",
    })
    void testWordPattern(String p, String s, boolean expected) {
        assertEquals(expected, WordPattern.wordPattern(p, s));
    }
}
