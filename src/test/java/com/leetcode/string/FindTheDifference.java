package com.leetcode.string;

public final class FindTheDifference {

    private static final int ALPHABET_SIZE = 26;

    private FindTheDifference() {
    }

    public static char findTheDifference(String s, String t) {
        char[] dict1 = dict(s);
        char[] dict2 = dict(t);
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (dict2[i] != dict1[i]) {
                return (char) ('a' + i);
            }
        }
        throw new IllegalStateException();
    }

    private static char[] dict(String s) {
        char[] dict = new char[ALPHABET_SIZE];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            dict[index]++;
        }
        return dict;
    }
}
