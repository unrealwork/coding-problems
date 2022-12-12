package com.leetcode.string;

public final class PermuationInString {
    private static final int ALPHABET_SIZE = 26;

    private PermuationInString() {
    }

    public static boolean checkInclusion(String s1, String s2) {
        int[] s1Dict = dict(s1);
        int[] slidingDict = new int[ALPHABET_SIZE];
        int i = 0;
        int j = 0;
        while (j < s2.length()) {
            slidingDict[symbolIndex(s2, j)]++;

            if ((j - i) == s1.length() - 1) {
                if (same(s1Dict, slidingDict)) {
                    return true;
                }
                i++;
                slidingDict[symbolIndex(s2, i - 1)]--;
            }
            j++;
        }
        return false;
    }

    private static boolean same(int[] d1, int[] d2) {
        for (int i = 0; i < d1.length; i++) {
            if (d1[i] != d2[i]) {
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
        return s.charAt(index) - 'a';
    }
}
