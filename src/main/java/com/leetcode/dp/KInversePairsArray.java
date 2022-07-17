package com.leetcode.dp;

final class KInversePairsArray {
    private static final int M = 1000000007;

    private KInversePairsArray() {
    }

    static int kInversePairs(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    int val;
                    if (j - i >= 0) {
                        val = (dp[i - 1][j] + M - dp[i - 1][j - i]) % M;
                    } else {
                        val = (dp[i - 1][j] + M) % M;
                    }
                    dp[i][j] = (dp[i][j - 1] + val) % M;
                }
            }
        }
        if (k > 0) {
            return (dp[n][k] + M - dp[n][k - 1]) % M;
        }
        return (dp[n][k] + M) % M;
    }
}
