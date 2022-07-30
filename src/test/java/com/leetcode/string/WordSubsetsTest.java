package com.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class WordSubsetsTest {

    public static Stream<Arguments> testData() {
        return Stream.of(
                arguments(
                        new String[] {"amazon", "apple", "facebook", "google", "leetcode"},
                        new String[] {"e", "o"},
                        Arrays.asList("facebook", "google", "leetcode")
                ),
                arguments(
                        new String[] {"amazon", "apple", "facebook", "google", "leetcode"},
                        new String[] {"l", "e"},
                        Arrays.asList("apple", "google", "leetcode")
                ),
                arguments(
                        new String[] {"amazon", "apple", "facebook", "google", "leetcode"},
                        new String[] {"lo", "eo"},
                        Arrays.asList("google", "leetcode")
                )
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void wordSubsets(String[] words1, String[] words2, List<String> expected) {
        final List<String> actual = WordSubsets.wordSubsets(words1, words2);
        Assertions.assertEquals(expected, actual);
    }
}
