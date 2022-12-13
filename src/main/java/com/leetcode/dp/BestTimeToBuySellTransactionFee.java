package com.leetcode.dp;

public final class BestTimeToBuySellTransactionFee {
    private BestTimeToBuySellTransactionFee() {
    }

    public static int maxProfit(int[] prices, int fee) {
        if (prices.length < 2) {
            return 0;
        }
        int bestBeforeDay = -prices[0] - fee;
        int[] dp = new int[prices.length + 1];
        for (int i = 1; i < prices.length; i++) {
            int prevBest = bestBeforeDay + prices[i];
            dp[i + 1] = Math.max(prevBest, dp[i]);
            if (dp[i] - prices[i] - fee > bestBeforeDay) {
                bestBeforeDay = dp[i] - prices[i] - fee;
            }
        }
        return dp[dp.length - 1];
    }
}
