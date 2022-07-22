package com.leetcode.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static com.leetcode.list.ListNodeUtils.toCollection;

class PartitionListTest {

    @ParameterizedTest
    @CsvSource( {
            "'1,4,3,2,5,2',3,'1,2,2,4,3,5'",
            "'2,1',2,'1,2'",
            "'2,1',0,'2,1'",
            "'2,1',3,'2,1'",
            "'',3,''"
    })
    void testPartition(@ConvertWith(ListNodeConverter.class) ListNode list, int x,
                       @ConvertWith(ListNodeConverter.class) ListNode expected) {
        ListNode actual = PartitionList.partition(list, x);
        Assertions.assertEquals(toCollection(expected), toCollection(actual));
    }
}
