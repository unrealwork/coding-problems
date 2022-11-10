package com.leetcode.string;

import java.util.ArrayDeque;
import java.util.Deque;

public final class RemoveAllAdjacentDuplicates {
    private RemoveAllAdjacentDuplicates() {
    }

    public static String removeDuplicates(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (deque.isEmpty() || deque.peekLast() != current) {
                deque.add(current);
            } else {
                deque.removeLast();
            }
        }

        StringBuilder sb = new StringBuilder();
        deque.forEach(sb::append);
        return sb.toString();
    }
}
