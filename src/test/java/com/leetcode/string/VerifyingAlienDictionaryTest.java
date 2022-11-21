package com.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class VerifyingAlienDictionaryTest {

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new String[] {"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz", true),
                Arguments.of(new String[] {"apple", "app"}, "abcdefghijklmnopqrstuvwxyz", false),
                Arguments.of(new String[] {"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz", false)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testIsAlienSorted(String[] words, String order, boolean expected) {
        boolean actual = VerifyingAlienDictionary.isAlienSorted(words, order);
        Assertions.assertEquals(expected, actual);
    }
}
