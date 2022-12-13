package com.leetcode.list;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RotateListTest {

    @ParameterizedTest
    @CsvSource( {
            "'1,2,3,4,5',2,'4,5,1,2,3'",
            "'0,1,2',4,'2,0,1'"
    })
    void testRotateRight(@ConvertWith(ListNodeConverter.class) ListNode list,
                         int k, @ConvertWith(IntListConverter.class) List<Integer> expected) {
        ListNode actual = RotateList.rotateRight(list, k);
        assertEquals(expected, ListNodeUtils.toCollection(actual));
    }
}
