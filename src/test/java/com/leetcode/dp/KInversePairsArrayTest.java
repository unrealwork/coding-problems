package com.leetcode.dp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KInversePairsArrayTest {

    @ParameterizedTest
    @CsvSource( {
            "1,0,1",
            "3,0,1",
            "3,1,2",
            "2,1,1",
            "5,2,9",
            "2,2,0",
            "3,1,2",
            "2,1,1",
            "0,1,0",
            "1,1,0",
            "4,2,5"
    })
    void testKInversePairs(int n, int k, int expected) {
        assertEquals(expected, KInversePairsArray.kInversePairs(n, k));
    }
}
