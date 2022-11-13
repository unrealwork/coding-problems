package com.leetcode.string;

import java.util.Arrays;

public final class ReverseWordsString {
    private ReverseWordsString() {
    }

    public static String reverseWords(String s) {
        String[] words = Arrays.stream(s.split("\\s+"))
                .filter(w -> !w.isEmpty())
                .toArray(String[]::new);
        StringBuilder builder = new StringBuilder();
        for (int i = words.length - 1; i >= 1; i--) {
            builder.append(words[i])
                    .append(' ');
        }
        if (words.length > 0) {
            builder.append(words[0]);
        }
        return builder.toString();
    }

}
