package com.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MakeStringGreatAgainTest {

    @ParameterizedTest
    @CsvSource( {
            "leEeetcode,leetcode",
            "abBAcC,''",
            "s,s"
    })
    void testMakeGood(String s, String expected) {
        Assertions.assertEquals(expected, MakeStringGreatAgain.makeGood(s));
    }
}
