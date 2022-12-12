package com.leetcode.hashmap;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskSchedulerTest {

    @ParameterizedTest
    @CsvSource( {
            "AAABBB,2,8",
            "AAABBB,0,6",
            "AAAAAABCDEFG,2,16"
    })
    void leastInterval(String s, int n, int expected) {
        int actual = TaskScheduler.leastInterval(s.toCharArray(), n);
        assertEquals(expected, actual);
    }
}
