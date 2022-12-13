package com.leetcode.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SortCharactersByFrequencyTest {

    @ParameterizedTest
    @CsvSource( {
            "tree,eert",
            "cccaaa,aaaccc",
            "Aabb,bbAa"
    })
    void testFrequencySort(String s, String expected) {
        assertEquals(expected, SortCharactersByFrequency.frequencySort(s));
    }
}
