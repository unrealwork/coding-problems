package com.leetcode.string;

public final class StringArrayEquals {
    private StringArrayEquals() {
    }

    @SuppressWarnings("squid:S3776")
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int word1Index = 0;
        int word2Index = 0;
        int char1Index = 0;
        int char2Index = 0;
        while (!isEndOfWords(word1, word1Index) && !isEndOfWords(word2, word2Index)) {
            boolean isCorrectWord1 = char1Index < word1[word1Index].length();
            boolean isCorrectWord2 = char2Index < word2[word2Index].length();
            if (isCorrectWord1 && isCorrectWord2) {
                if (word1[word1Index].charAt(char1Index) != word2[word2Index].charAt(char2Index)) {
                    return false;
                } else {
                    char1Index++;
                    char2Index++;
                }
            } else {
                if (!isCorrectWord1) {
                    word1Index++;
                    char1Index = 0;
                }
                if (!isCorrectWord2) {
                    word2Index++;
                    char2Index = 0;
                }
            }
        }
        return isEndOfWords(word1, word1Index) && isEndOfWords(word2, word2Index);
    }


    private static boolean isEndOfWords(String[] word1, int word1Index) {
        return word1Index == word1.length;
    }
}
