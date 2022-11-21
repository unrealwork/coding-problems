package com.leetcode.string;

public final class MergeStringsAlternately {
    private MergeStringsAlternately() {
    }

    public static String mergeAlternately(String word1, String word2) {
        char[] res = new char[word1.length() + word2.length()];
        int j = 0;
        int i = 0;
        int k = 0;
        while (k < res.length) {
            if (i < word1.length()) {
                res[k] = word1.charAt(i);
                i++;
                k++;
            }
            if (j < word2.length()) {
                res[k] = word2.charAt(j);
                j++;
                k++;
            }
        }
        return new String(res);
    }
}
