package com.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

class MyQueue {
    private Deque<Integer> popStack;
    private Deque<Integer> pushStack;

    MyQueue() {
        this.popStack = new ArrayDeque<>();
        this.pushStack = new ArrayDeque<>();
    }

    void push(int x) {
        if (popStack.isEmpty()) {
            popStack.addLast(x);
        } else {
            int size = popStack.size();
            while (!popStack.isEmpty()) {
                pushStack.addLast(popStack.removeLast());
            }
            popStack.addLast(x);
            for (int i = 0; i < size; i++) {
                popStack.addLast(pushStack.removeLast());
            }
        }
    }

    int pop() {
        return popStack.removeLast();
    }

    int peek() {
        return popStack.peekLast();
    }

    boolean empty() {
        return popStack.isEmpty();
    }
}
