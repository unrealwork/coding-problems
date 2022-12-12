package com.leetcode.string;

import java.util.Comparator;
import java.util.LinkedList;

public final class SortCharactersByFrequency {
    private static final int ALPHABET_SIZE = 256;

    private SortCharactersByFrequency() {
    }

    public static String frequencySort(String s) {
        int[] freq = dict(s);
        char[] resArray = new char[s.length()];
        LinkedList<Integer> indexes = new LinkedList<>();
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                indexes.add(i);
            }
        }
        indexes.sort(Comparator.comparingInt((Integer i) -> freq[i]).reversed());
        int j = 0;
        for (Integer i : indexes) {
            char c = (char) (i.intValue());
            for (int k = 0; k < freq[i]; k++) {
                resArray[j] = c;
                j++;
            }
        }
        return new String(resArray);
    }


    private static int[] dict(String s) {
        int[] dict = new int[ALPHABET_SIZE];
        for (int i = 0; i < s.length(); i++) {
            dict[s.codePointAt(i)]++;
        }
        return dict;
    }
}
