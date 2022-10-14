package com.leetcode.list;

/**
 * You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.
 *
 * @see <a href="https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/">Delete the Middle Node of a Linked List</a>
 */
public final class RemoveMiddleElement {
    private RemoveMiddleElement() {
    }

    public static ListNode deleteMiddle(ListNode head) {
        final ListNode prevMiddle = prevMiddleElement(head);
        if (prevMiddle == null) {
            return null;
        }
        prevMiddle.next = prevMiddle.next.next;
        return head;
    }

    private static ListNode prevMiddleElement(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode res = null;
        ListNode it = head;
        int size = 1;
        while (it != null) {
            if (size % 2 == 0) {
                if (res == null) {
                    res = head;
                } else {
                    res = res.next;
                }
            }
            size++;
            it = it.next;
        }
        return res;
    }
}
