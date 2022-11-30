package com.leetcode.list;

public final class RemoveDuplicatesFromSortedList {
    private RemoveDuplicatesFromSortedList() {
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode it = getNextNonDuplicated(head);
        ListNode resHead = it;
        if (resHead == null) {
            return null;
        }
        ListNode prev = it;
        it = it.next;
        while (it != null) {
            it = getNextNonDuplicated(it);
            prev.next = it;
            prev = prev.next;
            if (it == null) {
                break;
            }
            it = it.next;
        }
        return resHead;
    }

    private static ListNode getNextNonDuplicated(ListNode it) {
        while (it != null && it.next != null && it.val == it.next.val) {
            while (it.next != null && it.val == it.next.val) {
                it = it.next;
            }
            it = it.next;
        }
        return it;
    }
}
