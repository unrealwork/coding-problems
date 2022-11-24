package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public final class LetterCasePermutation {
    private LetterCasePermutation() {
    }

    public static List<String> letterCasePermutation(String s) {
        List<String> permutations = new ArrayList<>();
        List<Integer> letterIndexes = letterIndexes(s);
        for (int k = 0; k <= letterIndexes.size(); k++) {
            addPermutations(letterIndexes, k, s.toCharArray(), 0, 0, permutations);
        }
        return permutations;
    }

    private static void addPermutations(final List<Integer> letterIndexes, int k, char[] perm, int curNum, int inUpperCase, List<String> res) {
        if (inUpperCase < k) {
            for (int i = curNum; i < letterIndexes.size(); i++) {
                Integer letterIndex = letterIndexes.get(i);
                char c = perm[letterIndex];
                if (Character.isLowerCase(c)) {
                    perm[letterIndex] = Character.toUpperCase(c);
                } else {
                    perm[letterIndex] = Character.toLowerCase(c);
                }
                addPermutations(letterIndexes, k, perm, i + 1, inUpperCase + 1, res);
                perm[letterIndex] = c;
            }
        } else {
            res.add(new String(perm));
        }
    }

    private static List<Integer> letterIndexes(String s) {
        List<Integer> indexes = new ArrayList<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                indexes.add(i);
            }
        }
        return indexes;
    }
}
