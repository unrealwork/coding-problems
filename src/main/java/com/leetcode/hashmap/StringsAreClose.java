package com.leetcode.hashmap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class StringsAreClose {
    private StringsAreClose() {
    }

    public static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        Map<Character, Integer> word1Dict = dict(word1);
        Map<Character, Integer> word2Dict = dict(word2);
        if (!word1Dict.keySet().equals(word2Dict.keySet())) {
            return false;
        }
        return sortedFreqValue(word1Dict).equals(sortedFreqValue(word2Dict));
    }

    private static List<Integer> sortedFreqValue(Map<Character, Integer> dict) {
        return dict.values().stream().sorted().collect(Collectors.toList());
    }

    private static Map<Character, Integer> dict(String s) {
        final Map<Character, Integer> dict = new HashMap<>();
        for (char c : s.toCharArray()) {
            dict.computeIfPresent(c, (k, v) -> v + 1);
            dict.putIfAbsent(c, 1);
        }
        return dict;
    }
}
