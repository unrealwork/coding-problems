package com.leetcode.dp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestPalindromicSubsequenceTest {

    @ParameterizedTest
    @CsvSource( {
            "bbbab,4",
            "cbbd,2",
            "cdaabc,4"
    })
    void testLongestPalindromeSubseq(String s, int expected) {
        assertEquals(expected, LongestPalindromicSubsequence.longestPalindromeSubseq(s));
    }
}
