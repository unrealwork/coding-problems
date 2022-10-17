package com.leetcode.string;

/**
 * A pangram is a sentence where every letter of the English alphabet appears at least once.
 * <p>
 * Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.
 */
public final class Pangram {
    private static final int ALPHABET_SIZE = 26;

    private Pangram() {
    }

    public static boolean checkIfPangram(String sentence) {
        int uniqueCharCount = 0;
        boolean[] charPresence = new boolean[ALPHABET_SIZE];
        for (char c : sentence.toCharArray()) {
            int symbolIndex = c - 'a';
            if (!charPresence[symbolIndex]) {
                charPresence[symbolIndex] = true;
                uniqueCharCount++;
                if (uniqueCharCount == ALPHABET_SIZE) {
                    return true;
                }
            }
        }
        return false;
    }
}
