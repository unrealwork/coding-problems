package com.leetcode.hashmap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RandomizedSetTest {

    public static Stream<Arguments> insertTestData() {
        return Stream.of(
                Arguments.arguments(
                        RandomizedSet.of(1, 2, 3),
                        2, false
                ),
                Arguments.arguments(
                        RandomizedSet.of(1, 2, 3),
                        4, true
                ),
                Arguments.arguments(
                        RandomizedSet.of(),
                        4, true
                )
        );
    }

    public static Stream<Arguments> removeTestData() {
        return Stream.of(
                Arguments.arguments(
                        RandomizedSet.of(1, 2, 3),
                        2, true
                ),
                Arguments.arguments(
                        RandomizedSet.of(1, 2, 3),
                        4, false
                ),

                Arguments.arguments(
                        RandomizedSet.of(),
                        4, false
                ),
                Arguments.arguments(
                        RandomizedSet.of(4),
                        4, true
                )
        );
    }

    @ParameterizedTest
    @MethodSource("insertTestData")
    void testInsert(RandomizedSet set, int insertedValue, boolean expected) {
        boolean insert = set.insert(insertedValue);
        Assertions.assertEquals(insert, expected);
        Assertions.assertFalse(set.insert(insertedValue));
    }

    @ParameterizedTest
    @MethodSource("removeTestData")
    void testRemove(RandomizedSet set, int insertedValue, boolean expected) {
        boolean insert = set.remove(insertedValue);
        Assertions.assertEquals(insert, expected);
    }

    @Test
    void getRandom() {
        RandomizedSet set = RandomizedSet.of(1, 2, 3);
        Assertions.assertDoesNotThrow(set::getRandom);
    }
}
