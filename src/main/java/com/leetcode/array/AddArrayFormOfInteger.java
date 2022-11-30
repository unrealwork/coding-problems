package com.leetcode.array;

import java.util.LinkedList;
import java.util.List;

public final class AddArrayFormOfInteger {
    private static final int BASE = 10;

    private AddArrayFormOfInteger() {
    }

    public static List<Integer> addToArrayForm(int[] num, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        int prev = 0;
        int rest = k;
        for (int i = num.length - 1; i > -1 || rest > 0; i--) {
            final int firstDigit;
            if (i > -1) {
                firstDigit = num[i];
            } else {
                firstDigit = 0;
            }
            final int secondDigit = rest % BASE;

            int tmp = prev + firstDigit + secondDigit;
            list.addFirst(tmp % BASE);
            prev = tmp / BASE;
            rest = rest / BASE;
        }
        if (prev > 0) {
            list.addFirst(prev);
        }
        return list;
    }
}
