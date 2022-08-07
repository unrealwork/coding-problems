package com.leetcode.backtracking;

import java.util.Arrays;

final class CountVowelPermutations {

    private static final int VOWELS_AMOUNT = 5;
    private static final int MODULO = 1000000007;
    private static final int[][] UPDATER = new int[][] {
            {1},
            {0, 2},
            {0, 1, 3, 4},
            {2, 4},
            {0}
    };

    private CountVowelPermutations() {
    }

    public static int countVowelPermutation(int n) {
        int[] vowelsCount = new int[VOWELS_AMOUNT];
        Arrays.fill(vowelsCount, 1);
        for (int i = 1; i < n; i++) {
            vowelsCount = next(vowelsCount);
        }
        int res = 0;
        for (int c : vowelsCount) {
            res += c;
            res = res % MODULO;
        }
        return res;
    }

    private static int[] next(int[] vowelsCount) {
        int[] nextCount = new int[vowelsCount.length];
        for (int i = 0; i < vowelsCount.length; i++) {
            for (int updatedSymbol : UPDATER[i]) {
                nextCount[updatedSymbol] += vowelsCount[i];
                nextCount[updatedSymbol] = nextCount[updatedSymbol] % MODULO;
            }
        }
        return nextCount;
    }
}
