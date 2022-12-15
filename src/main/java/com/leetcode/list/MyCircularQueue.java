package com.leetcode.list;

final class MyCircularQueue {
    private final int maxSize;
    private ListNode head;
    private ListNode tail;
    private int size = 0;

    MyCircularQueue(int k) {
        this.head = null;
        this.tail = null;
        this.maxSize = k;
    }

    public boolean enQueue(int value) {
        if (!isFull()) {
            addAtTail(value);
            return true;
        }
        return false;
    }

    public boolean deQueue() {
        if (!isEmpty()) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
            }
            size--;
            return true;
        }
        return false;
    }

    @SuppressWarnings( {"checkstyle:MethodName", "squid:S100"})
    public int Front() {
        if (head != null) {
            return head.val;
        }
        return -1;
    }

    @SuppressWarnings( {"checkstyle:MethodName", "squid:S100"})
    public int Rear() {
        if (tail != null) {
            return tail.val;
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }


    private void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        if (tail == null) {
            tail = newNode;
            head = tail;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
}
