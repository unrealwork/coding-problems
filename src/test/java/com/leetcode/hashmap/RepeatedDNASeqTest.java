package com.leetcode.hashmap;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RepeatedDNASeqTest {

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT", List.of(
                                "AAAAACCCCC", "CCCCCAAAAA"
                        )
                ),
                Arguments.of("AAAAAAAAAAAAA", List.of("AAAAAAAAAA")),
                Arguments.of("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT", List.of(
                        "AAAAACCCCC", "CCCCCAAAAA"
                ))
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testFindRepeatedDnaSequences(String s, List<String> expected) {
        List<String> actual = RepeatedDNASeq.findRepeatedDnaSequences(s);
        assertEquals(expected, actual);
    }
}
