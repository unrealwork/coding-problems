package com.leetcode.list;

public final class RemoveElements {
    private RemoveElements() {
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode res = null;
        ListNode last = null;
        ListNode it = head;
        while (it != null) {
            if (it.val != val) {
                if (last == null) {
                    last = new ListNode(it.val);
                    res = last;
                } else {
                    last.next = new ListNode(it.val);
                    last = last.next;
                }
            }
            it = it.next;
        }
        return res;
    }
}
