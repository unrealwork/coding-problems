package com.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ReverseString3Test {

    @ParameterizedTest
    @CsvSource( {
            "'Let''s take LeetCode contest', 's''teL ekat edoCteeL tsetnoc'",
            "'God Ding', 'doG gniD'"
    })
    void testReverseWords(String s, String expected) {
        Assertions.assertEquals(expected, ReverseString3.reverseWords(s));
    }
}
