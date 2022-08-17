package com.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.leetcode.string.UniqueMorseCodes.uniqueMorseRepresentations;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class UniqueMorseCodesTest {

    public static Stream<Arguments> testData() {
        return Stream.of(
                arguments(new String[] {"gin", "zen", "gig", "msg"}, 2),
                arguments(new String[] {"a"}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testUniqueMorseRepresentations(String[] words, int expected) {
        Assertions.assertEquals(expected, uniqueMorseRepresentations(words));
    }

}
