package com.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FindTheDifferenceTest {

    @ParameterizedTest
    @CsvSource( {
            "abcd,abcde,e",
            "'',y,y"
    })
    void testFindTheDifference(String s, String t, char expected) {
        char actual = FindTheDifference.findTheDifference(s, t);
        Assertions.assertEquals(expected, actual);
    }
}
