package com.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RichestCustomerWealthTest {

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[][] {{1, 2, 3}, {3, 2, 1}}, 6)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testMaximumWealth(int[][] accounts, int expected) {
        Assertions.assertEquals(expected, RichestCustomerWealth.maximumWealth(accounts));
    }
}
