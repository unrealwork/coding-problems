package com.leetcode.stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumRemoveToMakeValidParenthesesTest {

    @ParameterizedTest
    @CsvSource( {
            "'lee(t(c)o)de)','lee(t(c)o)de'",
            "'a)b(c)d','ab(c)d'",
            "'))((',''"
    })
    void testMinRemoveToMakeValid(String s, String expected) {
        assertEquals(expected, MinimumRemoveToMakeValidParentheses.minRemoveToMakeValid(s));
    }
}
