package com.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RestoreIPAddressesTest {

    public static Stream<Arguments> testData() {
        return Stream.of(
                arguments("25525511135", asList("255.255.11.135", "255.255.111.35")),
                arguments("101023", asList("1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3"))
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void restoreIpAddresses(String s, List<String> expected) {
        Assertions.assertEquals(expected, RestoreIPAddresses.restoreIpAddresses(s));
    }
}
