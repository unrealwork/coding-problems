package com.leetcode.recursion;

import java.util.ArrayDeque;
import java.util.Deque;

public final class DecodeString {

    private static final int BASE = 10;

    private DecodeString() {
    }

    public static String decodeString(String s) {
        Deque<Integer> count = new ArrayDeque<>();
        Deque<StringBuilder> result = new ArrayDeque<>();
        int i = 0;
        result.push(new StringBuilder());
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (Character.isDigit(s.charAt(i))) {
                int resultNumber = s.charAt(i) - '0';
                while (Character.isDigit(s.charAt(i + 1))) {
                    resultNumber = resultNumber * BASE + (s.charAt(i + 1) - '0');
                    i++;
                }
                count.push(resultNumber);
            } else if (ch == '[') {
                result.push(new StringBuilder());
            } else if (ch == ']') {
                String str = result.pop().toString();
                int times = count.pop();
                result.peek().append(str.repeat(times));
            } else {
                result.peek().append(ch);
            }
            i++;
        }
        return result.pop().toString();
    }
}
