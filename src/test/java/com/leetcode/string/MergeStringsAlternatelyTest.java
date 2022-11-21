package com.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MergeStringsAlternatelyTest {

    @ParameterizedTest
    @CsvSource( {
            "abc,pqr,apbqcr",
            "ab,pqrs,apbqrs"
    })
    void testMergeAlternately(String s1, String s2, String expected) {
        String actual = MergeStringsAlternately.mergeAlternately(s1, s2);
        Assertions.assertEquals(expected, actual);
    }
}
