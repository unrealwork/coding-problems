package com.leetcode.list;

import java.util.ArrayDeque;
import java.util.Deque;

public final class AddTwoNumbers2 {

    private static final int BASE = 10;

    private AddTwoNumbers2() {
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbersRec(reversedDeque(l1), reversedDeque(l2));
    }

    private static Deque<Integer> reversedDeque(ListNode head) {
        Deque<Integer> reversedList = new ArrayDeque<>();
        ListNode it = head;
        while (it != null) {
            reversedList.addFirst(it.val);
            it = it.next;
        }
        return reversedList;
    }

    private static ListNode addTwoNumbersRec(Deque<Integer> d1, Deque<Integer> d2) {
        ListNode res = null;

        int rem = 0;
        while (!d1.isEmpty() || !d2.isEmpty()) {
            int newVal = rem;
            if (!d1.isEmpty()) {
                newVal += d1.removeFirst();
            }
            if (!d2.isEmpty()) {
                newVal += d2.removeFirst();
            }
            ListNode newNode = new ListNode(newVal % BASE);
            rem = newVal / BASE;
            newNode.next = res;
            res = newNode;
        }
        if (rem > 0) {
            ListNode newRes = new ListNode(rem);
            newRes.next = res;
            return newRes;
        }

        return res;
    }
}
