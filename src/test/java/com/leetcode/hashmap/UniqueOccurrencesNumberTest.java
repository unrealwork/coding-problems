package com.leetcode.hashmap;

import com.leetcode.array.IntArrayConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UniqueOccurrencesNumberTest {

    @ParameterizedTest
    @CsvSource( {
            "'1,2,2,1,1,3',true",
            "'1,2',false"
    })
    void testUniqueOccurrences(@ConvertWith(IntArrayConverter.class) int[] arr, boolean expected) {
        boolean actual = UniqueOccurrencesNumber.uniqueOccurrences(arr);
        assertEquals(expected, actual);
    }
}
