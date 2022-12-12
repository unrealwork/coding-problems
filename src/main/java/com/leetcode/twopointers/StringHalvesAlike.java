package com.leetcode.twopointers;

public final class StringHalvesAlike {
    private static final int ALPHABET_SIZE = 256;
    private static final char[] VOWELS = {'a', 'o', 'e', 'i', 'u'};
    private static final boolean[] VOWEL_DICT = vowelDict();


    private StringHalvesAlike() {
    }

    public static boolean halvesAreAlike(String s) {
        char[] word = s.toCharArray();
        int i = 0;
        int j = word.length - 1;
        int vowelBalance = 0;
        while (i < j) {
            if (isVowel(word[i])) {
                vowelBalance++;
            }
            if (isVowel(word[j])) {
                vowelBalance--;
            }
            i++;
            j--;
        }
        return vowelBalance == 0;
    }


    private static boolean isVowel(char c) {
        return VOWEL_DICT[c];
    }

    private static boolean[] vowelDict() {
        boolean[] dict = new boolean[ALPHABET_SIZE];
        for (char c : VOWELS) {
            dict[c] = true;
            dict[Character.toUpperCase(c)] = true;
        }
        return dict;
    }
}
