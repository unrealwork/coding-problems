package com.leetcode.list;

import java.util.ArrayDeque;
import java.util.Deque;

public final class RotateList {
    private RotateList() {
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        Deque<ListNode> reversed = reversedDeque(head);
        int shift = k % reversed.size();
        ListNode res = head;
        for (int i = 0; i < shift; i++) {
            ListNode tail = reversed.removeFirst();
            tail.next = res;
            if (!reversed.isEmpty()) {
                reversed.peekFirst().next = null;
            }
            res = tail;
        }
        return res;
    }

    private static Deque<ListNode> reversedDeque(ListNode head) {
        Deque<ListNode> reversedList = new ArrayDeque<>();
        ListNode it = head;
        while (it != null) {
            reversedList.addFirst(it);
            it = it.next;
        }
        return reversedList;
    }
}
