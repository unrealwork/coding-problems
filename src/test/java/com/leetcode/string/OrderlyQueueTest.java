package com.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OrderlyQueueTest {

    @ParameterizedTest
    @CsvSource( {
            "cba, 1, acb",
            "baaca, 3, aaabc"
    })
    void testOrderlyQueue(String s, int k, String expected) {
        Assertions.assertEquals(expected, OrderlyQueue.orderlyQueue(s, k));
    }
}
