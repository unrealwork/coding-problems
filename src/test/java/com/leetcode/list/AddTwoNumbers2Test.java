package com.leetcode.list;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddTwoNumbers2Test {

    @ParameterizedTest
    @CsvSource( {
            "'7,2,4,3','5,6,4','7,8,0,7'"
    })
    void addTwoNumbers(@ConvertWith(ListNodeConverter.class) ListNode l1,
                       @ConvertWith(ListNodeConverter.class) ListNode l2,
                       @ConvertWith(IntListConverter.class) List<Integer> expected) {
        Collection<Integer> actual = ListNodeUtils.toCollection(AddTwoNumbers2.addTwoNumbers(l1, l2));
        assertEquals(expected, actual);
    }
}
