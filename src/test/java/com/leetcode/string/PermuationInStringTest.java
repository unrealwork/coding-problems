package com.leetcode.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PermuationInStringTest {

    @ParameterizedTest
    @CsvSource( {
            "ab,eidbaooo,true",
            "ab,eidboaoo,false"
    })
    void testCheckInclusion(String s1, String s2, boolean expected) {
        assertEquals(expected, PermuationInString.checkInclusion(s1, s2));
    }
}
