package com.leetcode.list;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static com.leetcode.list.ListNodeUtils.toCollection;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseListIITest {

    @ParameterizedTest
    @CsvSource( {
            "'1,2,3,4,5',2,4,'1,4,3,2,5'",
            "'1,2,3,4,5',3,4,'1,2,4,3,5'",
            "'5',1,1,'5'",
            "'3,5',1,2,'5,3'"
    })
    void testReverseBetween(@ConvertWith(ListNodeConverter.class) ListNode list,
                            int left, int right,
                            @ConvertWith(ListNodeConverter.class) ListNode expected
    ) {
        ListNode actual = ReverseListII.reverseBetween(list, left, right);
        assertEquals(toCollection(expected), toCollection(actual));
    }
}
