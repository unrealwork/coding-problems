package com.leetcode.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static com.leetcode.list.ListNodeUtils.toCollection;

class OddEvenListTest {
    @ParameterizedTest
    @CsvSource( {"'1,2,3', '1,3,2'", "'1,2,3,4,5', '1,3,5,2,4'"})
    void testOddEvenList(@ConvertWith(ListConverter.class) ListNode node,
                         @ConvertWith(ListConverter.class) ListNode expected) {
        ListNode oddEvenList = OddEvenList.oddEvenList(node);
        Assertions.assertEquals(toCollection(expected),
                toCollection(oddEvenList));
    }

}
