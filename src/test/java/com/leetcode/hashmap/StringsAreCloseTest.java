package com.leetcode.hashmap;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringsAreCloseTest {

    @ParameterizedTest
    @CsvSource( {
            "abc,bca,true",
            "word,aa,false",
            "cabbba,abbccc,true",
            "uau,ssx,false"
    })
    void testClosesStrings(String w1, String w2, boolean expected) {
        boolean actual = StringsAreClose.closeStrings(w1, w2);
        assertEquals(expected, actual);
    }
}
