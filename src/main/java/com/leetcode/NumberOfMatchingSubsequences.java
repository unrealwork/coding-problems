package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

final class NumberOfMatchingSubsequences {

    static final int ALPHABET_SIZE = 26;

    private NumberOfMatchingSubsequences() {

    }

    public static int numMatchingSubseq(String s, String[] words) {
        Map<Character, Deque<StringIterator>> iteratorAtCharMap = new HashMap<>(ALPHABET_SIZE);
        for (String word : words) {
            StringIterator it = new StringIterator(word);
            it.next();
            iteratorAtCharMap.computeIfAbsent(word.charAt(0), c -> new ArrayDeque<>())
                    .add(it);
        }
        int count = 0;
        for (char c : s.toCharArray()) {
            Deque<StringIterator> iteratorAtCharList = iteratorAtCharMap.computeIfAbsent(c, ch -> new ArrayDeque<>());
            int size = iteratorAtCharList.size();
            for (int i = 0; i < size; i++) {
                StringIterator it = iteratorAtCharList.remove();
                if (it.hasNext()) {
                    Character nextCh = it.next();
                    iteratorAtCharMap.computeIfAbsent(nextCh, ch -> new ArrayDeque<>())
                            .add(it);
                } else {
                    count++;
                }
            }
        }
        return count;
    }

    private static final class StringIterator implements Iterator<Character> {
        private final String word;
        private int index = 0;

        private StringIterator(String word) {
            this.word = word;
        }

        @Override
        public boolean hasNext() {
            return index < word.length();
        }

        @Override
        public Character next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Character c = word.charAt(index);
            index++;
            return c;
        }
    }
}
