package com.leetcode.slidingwindow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumWindowSubstringTest {

    @ParameterizedTest
    @CsvSource( {
            "ADOBECODEBANC,ABC, BANC",
            "z,z,z",
            "a,aa,''"
    })
    void testMinWindow(String s, String t, String expected) {
        assertEquals(expected, MinimumWindowSubstring.minWindow(s, t));
    }
}
