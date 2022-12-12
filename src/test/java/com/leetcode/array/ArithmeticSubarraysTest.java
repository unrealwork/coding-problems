package com.leetcode.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArithmeticSubarraysTest {

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(
                        new int[] {4, 6, 5, 9, 3, 7},
                        new int[] {0, 0, 2},
                        new int[] {2, 3, 5},
                        List.of(true, false, true)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testCheckArithmeticSubarrays(int[] nums, int[] l, int[] r, List<Boolean> expected) {
        List<Boolean> actual = ArithmeticSubarrays.checkArithmeticSubarrays(nums, l, r);
        assertEquals(expected, actual);
    }
}
