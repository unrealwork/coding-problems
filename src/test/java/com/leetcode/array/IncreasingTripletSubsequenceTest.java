package com.leetcode.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static com.leetcode.array.IncreasingTripletSubsequence.increasingTriplet;
import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("array contains increasing triple")
class IncreasingTripletSubsequenceTest {
    @ParameterizedTest
    @CsvSource( {"'1,2,3', true", "'5,4,3,2,1', false", "'2,1,5,0,4,6', true"})
    void test(final @ConvertWith(IntArrayConverter.class) int[] arr, boolean hasIncreasingTriple) {
        assertEquals(increasingTriplet(arr), hasIncreasingTriple);
    }
}
