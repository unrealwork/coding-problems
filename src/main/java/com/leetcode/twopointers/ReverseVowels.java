package com.leetcode.twopointers;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;

public final class ReverseVowels {
    private static final Set<Character> VOWELS = new HashSet<>(asList('a', 'o', 'u', 'e', 'i', 'A', 'O', 'E', 'U', 'I'));

    private ReverseVowels() {

    }

    public static String reverseVowels(String s) {
        int i = 0;
        int j = s.length() - 1;
        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();
        while (i < j) {
            char leftSymbol = s.charAt(i);
            boolean isLeftVowel = isVowel(leftSymbol);
            char rightSymbol = s.charAt(j);
            boolean isRightVowel = isVowel(rightSymbol);
            if (isLeftVowel && isRightVowel) {
                left.append(rightSymbol);
                right.append(leftSymbol);
                i++;
                j--;
            } else {
                if (!isLeftVowel) {
                    left.append(leftSymbol);
                    i++;
                }
                if (!isRightVowel) {
                    right.append(rightSymbol);
                    j--;
                }
            }
        }
        if (i == j) {
            return left.toString() + s.charAt(i) + right.reverse();
        } else {
            return left.toString() + right.reverse();
        }
    }

    static boolean isVowel(final char c) {
        return VOWELS.contains(c);
    }
}
