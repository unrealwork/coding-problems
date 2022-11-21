package com.leetcode.string;

public final class VerifyingAlienDictionary {
    private VerifyingAlienDictionary() {
    }

    public static boolean isAlienSorted(String[] words, String order) {
        int[] o = order(order);
        for (int i = 1; i < words.length; i++) {
            if (isLess(words[i], words[i - 1], o)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isLess(String s1, String s2, int[] order) {
        final int minSize = Math.min(s1.length(), s2.length());
        for (int i = 0; i < minSize; i++) {
            int order1 = order[s1.charAt(i) - 'a'];
            int order2 = order[s2.charAt(i) - 'a'];
            if (order1 > order2) {
                return false;
            } else {
                if (order1 != order2) {
                    return true;
                }
            }
        }
        return s1.length() < s2.length();
    }

    private static int[] order(String order) {
        int[] dict = new int[26];
        for (int i = 0; i < order.length(); i++) {
            dict[order.charAt(i) - 'a'] = i;
        }
        return dict;
    }
}
