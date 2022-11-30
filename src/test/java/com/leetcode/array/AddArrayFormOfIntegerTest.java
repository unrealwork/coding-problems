package com.leetcode.array;

import com.leetcode.list.IntListConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddArrayFormOfIntegerTest {

    @ParameterizedTest
    @CsvSource( {
            "'1,2,0,0',34,'1,2,3,4'",
            "'3,4',1200,'1,2,3,4'",
            "'9,9,9',1,'1,0,0,0'",
            "'2,7,4',181,'4,5,5'",
            "'2,1,5',806,'1,0,2,1'"
    })
    void testAddToArrayForm(@ConvertWith(IntArrayConverter.class) int[] numArr, int num,
                            @ConvertWith(IntListConverter.class) List<Integer> expected) {
        List<Integer> actual = AddArrayFormOfInteger.addToArrayForm(numArr, num);
        assertEquals(expected, actual);
    }
}
