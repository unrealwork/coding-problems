package com.leetcode.dp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximalSquareTest {

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new char[][] {
                        {'1', '0', '1', '0', '0'},
                        {'1', '0', '1', '1', '1'},
                        {'1', '1', '1', '1', '1'},
                        {'1', '0', '0', '1', '0'}
                }, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testMaximalSquare(char[][] arr, int expected) {
        assertEquals(expected, MaximalSquare.maximalSquare(arr));
    }
}
