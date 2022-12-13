package com.leetcode.dp;

public final class LongestPalindromicSubsequence {

    private LongestPalindromicSubsequence() {
    }

    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = n; j > 0; j--) {
                if (s.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][n - j + 1] = dp[i - 1][n - j] + 1;
                } else {
                    dp[i][n - j + 1] = Math.max(dp[i - 1][n - j + 1], dp[i][n - j]);
                }
            }
        }
        return dp[n][n];
    }
}
