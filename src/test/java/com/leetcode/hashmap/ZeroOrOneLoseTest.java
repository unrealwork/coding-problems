package com.leetcode.hashmap;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZeroOrOneLoseTest {

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[][] {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7},
                                {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}},
                        List.of(
                                List.of(1, 2, 10),
                                List.of(4, 5, 7, 8)
                        ))
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void findWinners(int[][] matches, List<List<Integer>> expected) {
        List<List<Integer>> actual = ZeroOrOneLose.findWinners(matches);
        assertEquals(expected, actual);
    }
}
