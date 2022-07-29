package com.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class FindReplacePattern {
    static final int ALPHABET_SIZE = 26;

    private FindReplacePattern() {

    }

    static List<String> findAndReplacePattern(String[] words, String pattern) {

        List<String> res = new ArrayList<>();
        int[][] patternCounts = wordIndexes(countChars(pattern));
        for (String word : words) {
            if (isMatchPattern(patternCounts, word)) {
                res.add(word);
            }
        }
        return res;
    }

    private static Map<Character, List<Integer>> countChars(String s) {
        Map<Character, List<Integer>> dict = new HashMap<>(ALPHABET_SIZE);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            dict.computeIfAbsent(c, k -> new ArrayList<>())
                    .add(i);
        }
        return dict;
    }

    private static boolean isMatchPattern(int[][] patternCounts, String word) {
        Map<Character, List<Integer>> wordDict = countChars(word);
        int[][] wordCounts = wordIndexes(wordDict);
        if (patternCounts.length == wordCounts.length) {
            return Arrays.equals(patternCounts, wordCounts, FindReplacePattern::arraysOrder);
        }
        return false;
    }

    private static int[][] wordIndexes(Map<Character, List<Integer>> wordDict) {
        int[][] res = new int[wordDict.size()][];
        int i = 0;
        for (List<Integer> integers : wordDict.values()) {
            res[i] = listToArray(integers);
            i++;
        }
        Arrays.sort(res, FindReplacePattern::arraysOrder);
        return res;
    }

    private static int[] listToArray(List<Integer> list) {
        int[] arr = new int[list.size()];
        int i = 0;
        for (Integer integer : list) {
            arr[i] = integer;
            i++;
        }
        return arr;
    }

    private static int arraysOrder(int[] o1, int[] o2) {
        for (int i = 0; i < Math.min(o1.length, o2.length); i++) {
            int res = Integer.compare(o1[i], o2[i]);
            if (res != 0) {
                return res;
            }
        }
        return Integer.compare(o1.length, o2.length);
    }
}
