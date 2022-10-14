package com.leetcode.list;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static com.leetcode.list.ListNodeUtils.toCollection;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveMiddleElementTest {

    @ParameterizedTest
    @CsvSource( {
            "'1,2,3','1,3'",
            "'',''",
            "'1',''",
            "'1,2,3,4','1,2,4'",
            "'1,3,4,7,1,2,6','1,3,4,1,2,6'"
    })
    void deleteMiddle(@ConvertWith(ListNodeConverter.class) ListNode head,
                      @ConvertWith(ListNodeConverter.class) ListNode expected) {
        ListNode actual = RemoveMiddleElement.deleteMiddle(head);
        assertEquals(toCollection(expected), toCollection(actual));
    }
}
