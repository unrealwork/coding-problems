package com.leetcode.list;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReorderListTest {

    @ParameterizedTest
    @CsvSource( {
            "'1,2,3,4','1,4,2,3'",
            "'1,2,3,4,5','1,5,2,4,3'",
            "'1,2','1,2'",
            "'1','1'"
    })
    void testReorderList(@ConvertWith(ListNodeConverter.class) ListNode list, @ConvertWith(IntListConverter.class) List<Integer> expected) {
        ReorderList.reorderList(list);
        Collection<Integer> actual = ListNodeUtils.toCollection(list);
        assertEquals(expected, actual);
    }
}
