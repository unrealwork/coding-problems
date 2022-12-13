package com.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public final class PartitionLabels {
    private static final int ALPHABET_SIZE = 128;

    private PartitionLabels() {
    }

    public static List<Integer> partitionLabels(String s) {
        int lastPartitionEnd = -1;
        int currentEnd = 0;
        int[] dict = lastIndexMap(s);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int lastSymbolIndex = dict[s.codePointAt(i)];
            boolean isLastOccurrence = lastSymbolIndex == i;
            if (isLastOccurrence && lastSymbolIndex == currentEnd) {
                res.add(i - lastPartitionEnd);
                lastPartitionEnd = i;
                currentEnd = i + 1;
            } else {
                if (currentEnd < lastSymbolIndex) {
                    currentEnd = lastSymbolIndex;
                }
            }
        }
        int lastPartitionSize = s.length() - 1 - lastPartitionEnd;
        if (lastPartitionSize > 0) {
            res.add(lastPartitionSize);
        }
        return res;
    }

    private static int[] lastIndexMap(String s) {
        int[] dict = new int[ALPHABET_SIZE];
        for (int i = 0; i < s.length(); i++) {
            int codePoint = s.codePointAt(i);
            dict[codePoint] = i;
        }
        return dict;
    }
}
