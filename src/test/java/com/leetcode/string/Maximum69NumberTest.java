package com.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Maximum69NumberTest {

    @ParameterizedTest
    @CsvSource( {
            "9669, 9969",
            "9996, 9999",
            "9999, 9999"
    })
    void maximum69Number(int n, int expected) {
        Assertions.assertEquals(expected, Maximum69Number.maximum69Number(n));
    }
}
