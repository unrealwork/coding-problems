package com.leetcode.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveAllAdjacentDuplicatesTest {

    @ParameterizedTest
    @CsvSource( {
            "abbaca, ca",
            "azxxzy, ay"
    })
    void testRemoveDuplicates(String s, String expected) {
        final String actual = RemoveAllAdjacentDuplicates.removeDuplicates(s);
        assertEquals(expected, actual);
    }
}
