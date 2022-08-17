package com.leetcode.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

final class UniqueMorseCodes {


    private UniqueMorseCodes() {
    }

    static int uniqueMorseRepresentations(String[] words) {
        Set<EncodedString> uniqueValues = new HashSet<>();
        for (String word : words) {
            EncodedString encodedString = new EncodedString(word);
            uniqueValues.add(encodedString);
        }
        return uniqueValues.size();
    }

    private static final class EncodedString {
        private static final String[] CODES = new String[] {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        private final List<Integer> dotsIndexes = new ArrayList<>();
        private final String original;
        private int totalSymbols = 0;

        EncodedString(String s) {
            this.original = s;
            for (int i = 0; i < s.length(); i++) {
                append(s.charAt(i));
            }
        }

        private void append(char c) {
            int index = c - 'a';
            String code = CODES[index];
            for (int i = 0; i < code.length(); i++) {
                char symbol = code.charAt(i);
                if (symbol == '.') {
                    dotsIndexes.add(totalSymbols + i);
                }
            }
            totalSymbols += code.length();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            EncodedString that = (EncodedString) o;
            return totalSymbols == that.totalSymbols && Objects.equals(dotsIndexes, that.dotsIndexes);
        }

        @Override
        public int hashCode() {
            return Objects.hash(dotsIndexes, totalSymbols);
        }

        @Override
        public String toString() {
            return "EncodedString{" + "dotsIndexes=" + dotsIndexes + ", original='" + original + '\'' + ", totalSymbols=" + totalSymbols + '}';
        }
    }
}
