package com.leetcode.slidingwindow;

public final class MinimumWindowSubstring {
    private static final int ALPHABET_SIZE = 64;

    private MinimumWindowSubstring() {
    }

    public static String minWindow(String s, String t) {
        int i = 0;
        int j = 0;
        int[] tDict = dict(t);
        int[] dict = new int[ALPHABET_SIZE];
        String res = "";
        while (j < s.length()) {
            int symbolIndex = symbolIndex(s, j);
            dict[symbolIndex]++;
            if (tDict[symbolIndex] > 0 && dict[symbolIndex] == tDict[symbolIndex] && isSubDict(tDict, dict)) {
                while (dict[symbolIndex(s, i)] > tDict[symbolIndex(s, i)]) {
                    dict[symbolIndex(s, i)]--;
                    i++;
                }
                if (res.isEmpty() || res.length() > j - i + 1) {
                    res = s.substring(i, j + 1);
                }
                dict[symbolIndex(s, i)]--;
                i++;
            }
            j++;
        }
        return res;
    }

    private static boolean isSubDict(int[] tDict, int[] dict) {
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (tDict[i] > dict[i]) {
                return false;
            }
        }
        return true;
    }


    private static int[] dict(String s) {
        int[] dict = new int[ALPHABET_SIZE];
        for (int i = 0; i < s.length(); i++) {
            dict[symbolIndex(s, i)]++;
        }
        return dict;
    }

    private static int symbolIndex(String s, int index) {
        return s.charAt(index) - 'A';
    }
}
