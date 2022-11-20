package com.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public final class BasicCalculator {

    private static final int BASE = 10;

    private BasicCalculator() {
    }

    public static int calculate(String s) {
        int total = 0;
        int sign = 1;
        int number = 0;
        Deque<Integer> signStack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                number = number * BASE + (c - '0');
            }

            if (c == '+' || c == '-') {
                total += sign * number;
                number = 0;
                sign = detectSign(c, signStack);
            }

            if (c == '(') {
                signStack.push(sign);
                number = 0;
            }

            if (c == ')') {
                total += sign * number;
                number = 0;
                signStack.pop();
            }
        }
        total += sign * number;
        return total;
    }

    private static int detectSign(char operation, Deque<Integer> signStack) {
        final int sign;
        if (operation == '-') {
            sign = -1;
        } else {
            sign = 1;
        }
        if (signStack.isEmpty()) {
            return sign;
        } else {
            return signStack.peek() * sign;
        }
    }
}
