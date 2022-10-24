package com.leetcode.backtracking;

import java.util.List;

public final class MaximumLengthConcatenatedString {
    private static final int MAX_WORDS = 16;
    private static final int ALL_COVERED = (1 << MAX_WORDS) - 1;

    private MaximumLengthConcatenatedString() {
    }

    public static int maxLength(List<String> arr) {
        return maxLengthRec(arr, 0, 0, 0);
    }

    private static int maxLengthRec(List<String> arr, int covered, int coveredLetters, int prevRes) {
        int max = prevRes;
        if (ALL_COVERED == covered) {
            return prevRes;
        }
        for (int i = 0; i < arr.size(); i++) {
            if (!isBitSet(covered, i)) {
                int newCoveredLetters = addWord(arr.get(i), coveredLetters);
                covered = setBit(covered, i);
                if (newCoveredLetters > -1) {
                    final int res = maxLengthRec(arr, setBit(covered, i), newCoveredLetters, prevRes + arr.get(i).length());
                    if (res > max) {
                        max = res;
                    }
                }
            }
        }
        return max;
    }

    private static int setBit(int num, int k) {
        return num | (1 << k);
    }


    private static boolean isBitSet(int num, int k) {
        return (num & (1 << k)) > 0;
    }

    private static int addWord(String word, int presentedLetters) {
        int res = presentedLetters;
        for (char c : word.toCharArray()) {
            int letterOrder = c - 'a';
            if (isBitSet(res, letterOrder)) {
                return -1;
            } else {
                res = setBit(res, letterOrder);
            }
        }
        return res;
    }
}
