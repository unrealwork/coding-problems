package com.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

class WordSearchIITest {

    public static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new char[][] {
                                {'o', 'a', 'a', 'n'},
                                {'e', 't', 'a', 'e'},
                                {'i', 'h', 'k', 'r'},
                                {'i', 'f', 'l', 'v'}
                        },
                        new String[] {"oath", "pea", "eat", "rain"},
                        asList("eat", "oath")
                )
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testFindWords(char[][] board, String[] words, List<String> expected) {
        var actual = WordSearchII.findWords(board, words);
        Assertions.assertEquals(new HashSet<>(expected), new HashSet<>(actual));
    }
}
