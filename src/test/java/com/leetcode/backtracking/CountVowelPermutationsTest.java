package com.leetcode.backtracking;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountVowelPermutationsTest {

    @ParameterizedTest
    @CsvSource( {
            "1,5",
            "2,10",
            "5,68"
    })
    void testCountVowelPermutation(int n, int expected) {
        assertEquals(expected, CountVowelPermutations.countVowelPermutation(n));
    }
}
