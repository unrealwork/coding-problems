package com.leetcode.recursion;

import java.util.ArrayDeque;
import java.util.Deque;

public final class DecodeString {

    private static final int BASE = 10;

    private DecodeString() {
    }

    public static String decodeString(String s) {
        return decode(s);
    }

    public static String decode(String s) {
        int i = 0;
        Deque<Integer> repeatStack = new ArrayDeque<>();
        StringBuilder result = new StringBuilder();
        StringBuilder current = new StringBuilder();
        Deque<String> resultStack = new ArrayDeque<>();
        while (i < s.length()) {
            int repeatCount = 0;
            while (Character.isDigit(s.charAt(i))) {
                repeatCount = repeatCount * BASE + (s.charAt(i) - '0');
                i++;
            }
            if (s.charAt(i) == '[') {
                repeatStack.addLast(repeatCount);
                resultStack.addLast(current.toString());
                current.setLength(0);
                i++; // skip opening bracket
            }
            while (i < s.length() && Character.isLetter(s.charAt(i))) {
                current.append(s.charAt(i));
                i++;
            }
            if (i < s.length() && s.charAt(i) == ']') {
                String stackPart = resultStack.removeLast();
                stackPart += (current.toString().repeat(repeatStack.removeLast()));
                resultStack.addLast(stackPart);
                current.setLength(0);
                i++;
            } else {
                if (repeatStack.isEmpty()) {
                    result.append(resultStack.removeLast());
                }
                current.setLength(0);
            }
        }
        return result.toString();
    }
}
