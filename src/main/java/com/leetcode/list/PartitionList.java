package com.leetcode.list;

final class PartitionList {
    private PartitionList() {
    }

    static ListNode partition(ListNode head, int x) {
        ListNode it = head;
        Appender afterAppender = Appender.empty();
        Appender beforeAppender = Appender.empty();
        while (it != null) {
            ListNode newNode = new ListNode(it.val);
            if (it.val >= x) {
                afterAppender.append(newNode);
            } else {
                beforeAppender.append(newNode);
            }
            it = it.next;
        }
        if (beforeAppender.head == null) {
            return afterAppender.head;
        }
        beforeAppender.tail.next = afterAppender.head;
        return beforeAppender.head;
    }


    private static final class Appender {
        private ListNode head;
        private ListNode tail;

        private Appender() {
        }

        static Appender empty() {
            return new Appender();
        }

        void append(ListNode newNode) {
            if (head == null) {
                head = newNode;
            }
            if (tail == null) {
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = tail.next;
            }
        }
    }
}
