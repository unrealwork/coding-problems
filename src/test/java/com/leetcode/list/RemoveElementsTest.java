package com.leetcode.list;

import com.leetcode.array.IntArrayConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class RemoveElementsTest {

    @ParameterizedTest
    @CsvSource("'1,3,5,3,-1',3,'1,5,-1'")
    void testRemoveElements(@ConvertWith(ListNodeConverter.class) ListNode list, int val,
                            @ConvertWith(IntArrayConverter.class) int[] expected) {
        ListNode actual = RemoveElements.removeElements(list, val);
        int[] actualArray = ListNodeUtils.toCollection(actual)
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
        Assertions.assertArrayEquals(expected, actualArray);
    }
}
