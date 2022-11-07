package com.leetcode.string;

public final class Maximum69Number {
    private Maximum69Number() {
    }

    public static int maximum69Number(int num) {
        String s = Integer.toString(num);
        char[] digits = s.toCharArray();
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == '6') {
                digits[i] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(digits));
    }
}
