package com.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class WordSubsets {
    private static final int ALPHABET_SIZE = 26;

    private WordSubsets() {
    }

    public static List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res = new ArrayList<>();
        int[] dict = dict(words2);
        for (String s : words1) {
            if (isUniversalForDict(s, dict)) {
                res.add(s);
            }
        }
        return res;
    }

    private static boolean isUniversalForDict(String word, int[] dict) {
        int[] wordDict = dict(word);
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (dict[i] > wordDict[i]) {
                return false;
            }
        }
        return true;
    }

    private static int[] dict(String... words) {
        int[] res = new int[ALPHABET_SIZE];
        int[] curDict = new int[ALPHABET_SIZE];
        for (String word : words) {
            Arrays.fill(curDict, 0);
            for (int i = 0; i < word.length(); i++) {
                curDict[word.charAt(i) - 'a']++;
            }
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                res[i] = Math.max(res[i], curDict[i]);
            }
        }
        return res;
    }
}
