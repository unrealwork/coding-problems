package com.leetcode.list;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

final class ListNodeUtils {
    private ListNodeUtils() {
    }

    static Collection<Integer> toCollection(ListNode head) {
        List<Integer> res = new LinkedList<>();
        ListNode it = head;
        while (it != null) {
            res.add(it.val);
            it = it.next;
        }
        return res;
    }
}
