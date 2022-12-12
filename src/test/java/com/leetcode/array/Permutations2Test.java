package com.leetcode.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Permutations2Test {

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[] {1, 1, 2}, Set.of(
                        asList(1, 1, 2),
                        asList(1, 2, 1),
                        asList(2, 1, 1)
                )),
                Arguments.of(new int[] {1, 2, 3}, Set.of(
                        asList(1, 2, 3),
                        asList(1, 3, 2),
                        asList(2, 1, 3),
                        asList(2, 3, 1),
                        asList(3, 1, 2),
                        asList(3, 2, 1)
                )),
                Arguments.of(new int[] {2, 2, 1, 1}, Set.of(
                        asList(1, 1, 2, 2),
                        asList(1, 2, 1, 2),
                        asList(1, 2, 2, 1),
                        asList(2, 1, 1, 2),
                        asList(2, 1, 2, 1),
                        asList(2, 2, 1, 1)
                ))
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void permuteUnique(int[] arr, Set<List<Integer>> expected) {
        List<List<Integer>> act = Permutations2.permuteUnique(arr);
        assertEquals(expected.size(), act.size());
        Set<List<Integer>> acutal = Set.copyOf(act);
        assertEquals(expected, acutal);
    }
}
