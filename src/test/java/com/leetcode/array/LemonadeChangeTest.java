package com.leetcode.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LemonadeChangeTest {

    @ParameterizedTest
    @CsvSource( {
            "'5,5,5,10,20',true",
            "'5,5,10,10,20',false"
    })
    void lemonadeChange(@ConvertWith(IntArrayConverter.class) int[] arr, boolean expeted) {
        assertEquals(expeted, LemonadeChange.lemonadeChange(arr));
    }
}
