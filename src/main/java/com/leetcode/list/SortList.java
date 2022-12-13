package com.leetcode.list;

import java.util.ArrayDeque;
import java.util.Deque;

public final class SortList {
    private SortList() {
    }

    public static ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        Deque<ListNode> deque = new ArrayDeque<>();
        ListNode it = head;
        while (it != null) {
            ListNode next = it.next;
            it.next = null;
            deque.addLast(it);
            it = next;
        }
        while (deque.size() > 1) {
            ListNode l1 = deque.removeLast();
            ListNode l2 = deque.removeLast();
            deque.addFirst(mergeTwoLists(l1, l2));
        }
        return deque.remove();
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = null;
        ListNode it1 = l1;
        ListNode it2 = l2;
        ListNode last = res;
        while (it1 != null && it2 != null) {
            ListNode newNode;
            if (it1.val < it2.val) {
                newNode = new ListNode(it1.val);
                it1 = it1.next;
            } else {
                newNode = new ListNode(it2.val);
                it2 = it2.next;
            }
            if (last == null) {
                last = newNode;
                res = newNode;
            } else {
                last.next = newNode;
                last = newNode;
            }
        }

        return handleRest(res, it1, it2, last);
    }

    private static ListNode handleRest(ListNode res, ListNode it1, ListNode it2, ListNode last) {
        if (it1 != null) {
            if (last != null) {
                last.next = it1;
            } else {
                res = it1;
            }
        }

        if (it2 != null) {
            if (last != null) {
                last.next = it2;
            } else {
                res = it2;
            }
        }
        return res;
    }
}
