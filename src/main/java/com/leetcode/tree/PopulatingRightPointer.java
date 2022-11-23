package com.leetcode.tree;

import util.ExcludeFromJacocoGeneratedReport;

@ExcludeFromJacocoGeneratedReport
public final class PopulatingRightPointer {
    private PopulatingRightPointer() {

    }

    public static Node connect(Node root) {
        Node it = root;
        Node head;
        Node tail;
        while (it != null) {
            head = null;
            tail = null;
            while (it != null) {
                if (it.left == null) {
                    return root;
                }
                if (head == null) {
                    head = it.left;
                    tail = head;
                } else {
                    tail.next = it.left;
                    tail = tail.next;
                }
                tail.next = it.right;
                tail = tail.next;
                it = it.next;
            }
            if (tail != null) {
                it = head;
            }
        }
        return root;
    }
}
