package com.leetcode.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class WordPattern {
    private WordPattern() {
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        int i = 0;
        Set<String> wordSet = new HashSet<>();
        for (String w : words) {
            char c = pattern.charAt(i);
            final String value = map.get(c);
            if (value == null) {
                map.put(c, w);
                wordSet.add(w);
                if (map.size() != wordSet.size()) {
                    return false;
                }
            } else {
                if (!value.equals(w)) {
                    return false;
                }
            }
            i++;
        }
        return true;
    }
}
