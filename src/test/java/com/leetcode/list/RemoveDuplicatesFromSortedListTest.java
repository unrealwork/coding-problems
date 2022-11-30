package com.leetcode.list;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveDuplicatesFromSortedListTest {

    @ParameterizedTest
    @CsvSource( {
            "'1,2,3,3,4,4,5','1,2,5'",
            "'1,1,1,2,3,3,4,4,5','2,5'",
            "'1,1,1,2,3','2,3'",
            "'1,1',''"
    })
    void testDeleteDuplicates(@ConvertWith(ListNodeConverter.class) ListNode list,
                              @ConvertWith(IntListConverter.class) List<Integer> expected) {
        Collection<Integer> actual = ListNodeUtils.toCollection(RemoveDuplicatesFromSortedList.deleteDuplicates(list));
        assertEquals(expected, actual);
    }

}
