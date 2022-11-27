package com.leetcode.recursion;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DecodeStringTest {

    @ParameterizedTest
    @CsvSource( {
            "3[a]2[bc],aaabcbc",
   /*         "3[a2[c]d],accdaccdaccd",
            "2[abc]3[cd]ef,abcabccdcdcdef",
            "3[z]2[2[y]pq4[2[jk]e1[f]]]ef,zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef"*/
    })
    void testDecodeString(String s, String expected) {
        String actual = DecodeString.decodeString(s);
        assertEquals(expected, actual);
    }
}
