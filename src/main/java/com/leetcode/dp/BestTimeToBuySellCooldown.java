package com.leetcode.dp;

public final class BestTimeToBuySellCooldown {
    private BestTimeToBuySellCooldown() {
    }

    public static int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int[] dp = new int[prices.length];
        dp[0] = 0;
        dp[1] = Math.max(0, prices[1] - prices[0]);
        int bestBoughtProfit = -Math.min(prices[0], prices[1]);
        for (int i = 2; i < prices.length; i++) {
            if (dp[i - 1] == dp[i - 2]) {
                bestBoughtProfit = Math.max(dp[i - 1] - prices[i - 1] + prices[i], bestBoughtProfit);
            } else {
                bestBoughtProfit = Math.max(dp[i - 2] - prices[i - 1] + prices[i], bestBoughtProfit);
            }
            dp[i] = Math.max(bestBoughtProfit, dp[i - 1]);
        }
        return dp[dp.length - 1];
    }
}
