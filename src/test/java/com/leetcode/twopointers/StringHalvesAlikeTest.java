package com.leetcode.twopointers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringHalvesAlikeTest {

    @ParameterizedTest
    @CsvSource( {
            "book,true",
            "textbook,false",
            "a,true",
            "AbCdEfGh,true"
    })
    void testHalvesAreAlike(String s, boolean expected) {
        assertEquals(expected, StringHalvesAlike.halvesAreAlike(s));
    }
}
