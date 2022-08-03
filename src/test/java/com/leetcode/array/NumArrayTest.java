package com.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class NumArrayTest {
    public static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.arguments(new int[] {1, 2, 3, 5, 6}, 0, 3, 11)
        );
    }

    public static Stream<Arguments> testUpdateData() {
        return Stream.of(
                Arguments.arguments(new int[] {1, 2, 3, 5, 6}, 0, 3, 6)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testSumRange(int[] arr, int l, int r, int expected) {
        final NumArray numArray = new NumArray(arr);
        int actual = numArray.sumRange(l, r);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("testUpdateData")
    void testUpdatedSum(int[] arr, int updatedValue, int updateIndex, int expected) {
        final NumArray numArray = new NumArray(arr);
        numArray.update(updateIndex, updatedValue);
        Assertions.assertEquals(expected, numArray.sumRange(0, 3));
    }

}
