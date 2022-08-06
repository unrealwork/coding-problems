package com.leetcode.math;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.leetcode.math.PoorPigs.poorPigs;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PoorPigsTest {

    @ParameterizedTest
    @CsvSource( {
            "1000,15,60,5",
            "4,15,15,2"
    })
    void testPoorPigs(int buckets, int minToDie, int minToTest, int expected) {
        int actual = poorPigs(buckets, minToDie, minToTest);
        assertEquals(expected, actual);
    }
}
