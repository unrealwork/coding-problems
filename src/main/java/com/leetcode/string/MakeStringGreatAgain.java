package com.leetcode.string;

import java.util.Deque;
import java.util.LinkedList;

public final class MakeStringGreatAgain {
    private MakeStringGreatAgain() {

    }

    public static String makeGood(String s) {
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (deque.isEmpty()) {
                deque.add(current);
            } else {
                char last = deque.peekLast();
                if (Character.toLowerCase(last) == Character.toLowerCase(current)) {
                    boolean isUpperLast = Character.isUpperCase(last);
                    boolean isUpperCur = Character.isUpperCase(current);
                    if (isUpperLast && !isUpperCur || !isUpperLast && isUpperCur) {
                        deque.removeLast();
                        continue;
                    }
                }
                deque.add(current);
            }
        }
        StringBuilder sb = new StringBuilder();
        deque.forEach(sb::append);
        return sb.toString();
    }
}
