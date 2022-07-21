package com.leetcode.list;

final class ReverseListII {
    private ReverseListII() {
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            throw new IllegalArgumentException();
        }
        ListNode it;
        ListNode lastNode;
        ListNode res;
        int i;
        if (left > 1) {
            it = head.next;
            res = new ListNode(head.val);
            lastNode = res;
            i = 2;
            while (i < left) {
                lastNode.next = new ListNode(it.val);
                i++;
                it = it.next;
                lastNode = lastNode.next;
            }
        } else {
            it = head;
            i = 1;
            lastNode = null;
            res = null;
        }
        if (it != null) {
            ListNode reversedNodeHead = new ListNode(it.val);
            ListNode reversedPartTail = reversedNodeHead;
            it = it.next;
            i++;
            while (i <= right) {
                ListNode tmpNode = new ListNode(it.val);
                tmpNode.next = reversedNodeHead;
                reversedNodeHead = tmpNode;
                i++;
                it = it.next;
            }
            if (lastNode != null) {
                lastNode.next = reversedNodeHead;
                lastNode = reversedPartTail;
            } else {
                lastNode = reversedPartTail;
                res = reversedNodeHead;
            }
            while (it != null) {
                lastNode.next = new ListNode(it.val);
                lastNode = lastNode.next;
                it = it.next;
            }
        }
        return res;
    }
}
