package com.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class FindReplacePatternTest {

    @Test
    void testFindAndReplacePattern() {
        String[] words = new String[] {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        String pattern = "abb";
        List<String> expected = Arrays.asList("mee", "aqq");
        List<String> actual = FindReplacePattern.findAndReplacePattern(words, pattern);
        Assertions.assertEquals(expected, actual);
    }
}
