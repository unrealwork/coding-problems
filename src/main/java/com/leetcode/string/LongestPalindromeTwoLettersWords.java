package com.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public final class LongestPalindromeTwoLettersWords {

    private static final int WORD_LEN = 2;

    private LongestPalindromeTwoLettersWords() {
    }

    public static int longestPalindrome(String[] words) {
        Map<String, Integer> withoutPalindromePair = new HashMap<>();
        int length = 0;
        for (String word : words) {
            final String palindrome = "" + word.charAt(1) + word.charAt(0);
            if (withoutPalindromePair.containsKey(palindrome)) {
                Integer count = withoutPalindromePair.get(palindrome);
                if (count == 1) {
                    withoutPalindromePair.remove(palindrome);
                } else {
                    withoutPalindromePair.put(palindrome, count - 1);
                }
                length += WORD_LEN * 2;
            } else {
                withoutPalindromePair.computeIfPresent(word, (k, v) -> v + 1);
                withoutPalindromePair.putIfAbsent(word, 1);
            }
        }
        if (withoutPalindromePair.keySet().stream().anyMatch(w -> w.charAt(0) == w.charAt(1))) {
            length += WORD_LEN;
        }
        return length;
    }
}
