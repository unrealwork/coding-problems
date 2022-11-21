package com.leetcode.string;

public final class DecryptIntegerAlphabet {

    private static final int BASE = 10;

    private DecryptIntegerAlphabet() {
    }

    public static String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            final int code;
            if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
                code = readDigit(s, i) * BASE + readDigit(s, i + 1);
                i += 3;
            } else {
                code = readDigit(s, i);
                i++;
            }

            sb.append((char) ('a' + code - 1));
        }
        return sb.toString();
    }

    private static int readDigit(String s, int i) {
        return s.charAt(i) - '0';
    }
}
