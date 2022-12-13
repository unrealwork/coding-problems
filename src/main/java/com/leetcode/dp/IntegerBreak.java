package com.leetcode.dp;

public final class IntegerBreak {
    private IntegerBreak() {
    }

    public static int integerBreak(int n) {
        return new Solver(n).solve();
    }


    private static final class Solver {
        private static final int BASE_CASE = 2;
        private final int n;
        private final int[] memo;

        private Solver(int n) {
            this.n = n;
            this.memo = new int[n + 1];
        }

        int solve() {
            return solve(n);
        }

        private int solve(int l) {
            if (memo[l] == 0) {
                if (l <= BASE_CASE + 1) {
                    memo[l] = l - 1;
                } else {
                    memo[l] = (l - BASE_CASE) * BASE_CASE;
                    for (int i = BASE_CASE; i <= BASE_CASE + 1; i++) {
                        int p = l - i;
                        memo[l] = Math.max(Math.max(i * p, i * solve(p)), memo[l]);
                    }
                }
                return memo[l];
            }
            return memo[l];
        }
    }
}
