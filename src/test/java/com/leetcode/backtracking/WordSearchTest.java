package com.leetcode.backtracking;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordSearchTest {
    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new char[][] {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                }, "ABCCED", true),
                Arguments.of(new char[][] {{'a'}},
                        "a", true)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testExist(char[][] board, String word, boolean expected) {
        assertEquals(expected, WordSearch.exist(board, word));
    }
}
