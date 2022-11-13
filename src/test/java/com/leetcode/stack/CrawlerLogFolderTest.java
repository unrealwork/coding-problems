package com.leetcode.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.leetcode.stack.CrawlerLogFolder.minOperations;

class CrawlerLogFolderTest {

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new String[] {}, 0),
                Arguments.of(new String[] {"d1/", "d2/", "../", "d21/", "./"}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testMinOperations(String[] logs, int expected) {
        Assertions.assertEquals(expected, minOperations(logs));
    }
}
