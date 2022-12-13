package com.leetcode.list;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SortListTest {

    @ParameterizedTest
    @CsvSource( {
            "'4,2,1,3','1,2,3,4'"
    })
    void testSortList(@ConvertWith(ListNodeConverter.class) ListNode listNode,
                      @ConvertWith(IntListConverter.class) List<Integer> expected) {
        assertEquals(expected, ListNodeUtils.toCollection(SortList.sortList(listNode)));
    }
}
