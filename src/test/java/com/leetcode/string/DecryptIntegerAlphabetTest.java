package com.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DecryptIntegerAlphabetTest {

    @ParameterizedTest
    @CsvSource( {
            "10#11#12,jkab"
    })
    void testFreqAlphabets(String s, String expected) {
        String actual = DecryptIntegerAlphabet.freqAlphabets(s);
        Assertions.assertEquals(expected, actual);
    }
}
