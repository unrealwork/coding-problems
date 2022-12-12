package com.leetcode.dp;

import java.util.Arrays;

public final class EditDistance {
    private EditDistance() {
    }

    public static int minDistance(String word1, String word2) {
        return Solver.of(word1, word2).solve();
    }

    static final class Solver {
        private final char[] word1;
        private final char[] word2;
        private final int[][] memo;

        private Solver(String word1, String word2) {
            this.word1 = word1.toCharArray();
            this.word2 = word2.toCharArray();
            this.memo = new int[this.word1.length + 1][this.word2.length + 1];
            for (int[] m : memo) {
                Arrays.fill(m, -1);
            }
        }

        private static Solver of(String word1, String word2) {
            return new Solver(word1, word2);
        }

        int solve() {
            return solve(0, 0);
        }

        private int solve(int i, int j) {
            if (i == word1.length || j == word2.length) {
                return Math.max(word1.length - i, word2.length - j);
            }
            if (memo[i][j] == -1) {
                if (word1[i] == word2[j]) {
                    memo[i][j] = solve(i + 1, j + 1);
                } else {
                    int ifReplaceBest = solve(i + 1, j + 1);
                    int ifInsertBest = solve(i, j + 1);
                    int ifRemoveBest = solve(i + 1, j);
                    memo[i][j] = Math.min(Math.min(ifInsertBest, ifRemoveBest), ifReplaceBest) + 1;
                }
            }
            return memo[i][j];
        }
    }
}
