package com.leetcode.dp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EditDistanceTest {

    @ParameterizedTest
    @CsvSource( {
            "horse,ros,3",
            "intention,execution,5",
            "sea,eat,2",
            "park,spake,3"
    })
    void testMinDistance(String word1, String word2, int expected) {
        assertEquals(expected, EditDistance.minDistance(word1, word2));
    }
}
