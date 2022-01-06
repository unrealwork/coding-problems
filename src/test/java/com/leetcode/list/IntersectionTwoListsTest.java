package com.leetcode.list;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static com.leetcode.list.ListNodeUtils.toCollection;
import static org.junit.jupiter.api.Assertions.assertEquals;

class IntersectionTwoListsTest {
    @ParameterizedTest
    @CsvSource( {"'4,1', '5,6,1', '8,4,5'", "'1,9,1', '3', '2,4'", "'2,6,4', '1,5', ''"})
    void test(final @ConvertWith(ListNodeConverter.class) ListNode beginA,
              final @ConvertWith(ListNodeConverter.class) ListNode beginB,
              final @ConvertWith(ListNodeConverter.class) ListNode intersection) {
        ListNode headA = concat(beginA, intersection);
        ListNode headB = concat(beginB, intersection);
        ListNode computedIntersection = IntersectionTwoLists.getIntersectionNode(headA, headB);
        assertEquals(toCollection(intersection), toCollection(computedIntersection));
    }

    private ListNode concat(ListNode headA, ListNode headB) {
        if (headA == null) {
            return headB;
        }
        headA.next = headB;
        return headA;
    }
}
