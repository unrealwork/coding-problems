package com.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

final class MinimumRemoveToMakeValidParentheses {
    private MinimumRemoveToMakeValidParentheses() {
    }

    static String minRemoveToMakeValid(String s) {
        Set<Integer> removedPositions = calcPositionsToRemove(s);
        char[] res = new char[s.length() - removedPositions.size()];
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!removedPositions.contains(i)) {
                res[j] = s.charAt(i);
                j++;
            }
        }
        return new String(res);
    }

    private static Set<Integer> calcPositionsToRemove(String s) {
        Deque<Integer> deque = new ArrayDeque<>();
        int i = 0;
        Set<Integer> removedPositions = new HashSet<>();
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '(' || c == ')') {
                if (c == '(') {
                    deque.addLast(i);
                } else {
                    if (!deque.isEmpty()) {
                        deque.removeLast();
                    } else {
                        removedPositions.add(i);
                    }
                }
            }
            i++;
        }
        while (!deque.isEmpty()) {
            removedPositions.add(deque.removeLast());
        }
        return removedPositions;
    }
}
