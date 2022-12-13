package com.leetcode.list;

import java.util.ArrayDeque;
import java.util.Deque;

public final class ReorderList {
    private ReorderList() {
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        Deque<ListNode> leftReversed = new ArrayDeque<>();
        ListNode slowIt = head;
        ListNode fastIt = head.next.next;
        boolean isEven = true;
        while (fastIt != null) {
            leftReversed.addLast(slowIt);
            slowIt = slowIt.next;
            fastIt = fastIt.next;
            if (fastIt != null) {
                fastIt = fastIt.next;
            } else {
                isEven = false;
            }
        }
        ListNode newHead = slowIt;
        ListNode rightHead;
        if (isEven) {
            rightHead = slowIt.next.next;
            newHead.next.next = null;
        } else {
            rightHead = slowIt.next;
            newHead.next = null;
        }

        while (!leftReversed.isEmpty()) {
            ListNode left = leftReversed.removeLast();
            ListNode next = rightHead.next;
            left.next = rightHead;
            left.next.next = newHead;
            rightHead = next;
            newHead = left;
        }
    }
}
