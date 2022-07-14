package com.leetcode.list;

final class OddEvenList {
    private OddEvenList() {
    }


    public static ListNode oddEvenList(ListNode head) {
        SimpleDeque oddDeque = new SimpleDeque();
        SimpleDeque evenDeque = new SimpleDeque();
        ListNode it = head;
        boolean isOdd = true;
        while (it != null) {
            if (isOdd) {
                oddDeque.add(it.val);
            } else {
                evenDeque.add(it.val);
            }
            isOdd = !isOdd;
            it = it.next;
        }
        if (oddDeque.tail != null) {
            oddDeque.tail.next = evenDeque.head;
        }
        return oddDeque.head;
    }

    private static final class SimpleDeque {
        private ListNode head;
        private ListNode tail;

        private SimpleDeque() {
        }

        public void add(final int val) {
            if (head == null) {
                head = new ListNode(val);
                tail = head;
            } else {
                tail.next = new ListNode(val);
                tail = tail.next;
            }
        }
    }
}
