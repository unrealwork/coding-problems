package com.leetcode.dp;

public final class PerfectSquares {

    private static final int MAX_SQUARED_NUM = 100;

    private PerfectSquares() {
    }

    public static int numSquares(int n) {
        int[] sqr = squares(MAX_SQUARED_NUM);
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 1; j < sqr.length; j++) {
                int s = sqr[j];
                if (s <= i) {
                    dp[i] = Math.min(dp[i - s] + 1, dp[i]);
                } else {
                    break;
                }
            }
        }
        return dp[n];
    }

    private static int[] squares(int n) {
        int[] arr = new int[n];
        for (int i = 1; i < n; i++) {
            arr[i - 1] = i * i;
        }
        return arr;
    }
}
