package com.leetcode.math;

import java.util.ArrayDeque;
import java.util.Deque;

final class NextGreaterElement3 {

    private static final int BASE = 10;

    private NextGreaterElement3() {
    }

    static int nextGreaterElement(int n) {
        long rest = n / BASE;
        int lastD = n % BASE;
        boolean hasGreatest = false;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(lastD);
        while (rest > 0) {
            int d = (int) rest % BASE;
            deque.addLast(d);
            rest /= BASE;
            if (d < lastD) {
                hasGreatest = true;
                break;
            }
            lastD = d;
        }
        if (!hasGreatest) {
            return -1;
        }
        Deque<Integer> changedPartOrder = buildChangedPartDigitOrder(deque);
        while (!changedPartOrder.isEmpty()) {
            rest = rest * BASE + changedPartOrder.removeFirst();
        }
        if (rest > Integer.MAX_VALUE) {
            return -1;
        }
        return (int) rest;
    }

    private static Deque<Integer> buildChangedPartDigitOrder(Deque<Integer> currentOrder) {
        Deque<Integer> newOrder = new ArrayDeque<>();
        int movedDigit = currentOrder.removeLast();
        while (!currentOrder.isEmpty()) {
            if (currentOrder.peekLast() > movedDigit) {
                newOrder.addFirst(currentOrder.removeLast());
            } else {
                break;
            }
        }
        int removed = newOrder.removeFirst();
        newOrder.addFirst(movedDigit);
        while (!currentOrder.isEmpty()) {
            newOrder.addFirst(currentOrder.removeLast());
        }
        newOrder.addFirst(removed);
        return newOrder;
    }
}
