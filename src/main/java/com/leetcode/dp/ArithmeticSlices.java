package com.leetcode.dp;

public final class ArithmeticSlices {

    private static final int MIN_SEQ_SIZE = 3;

    private ArithmeticSlices() {
    }

    public static int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < MIN_SEQ_SIZE) {
            return 0;
        }
        int total = 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if (diff == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 2;
            }
            if (dp[i] > 2) {
                total += (dp[i] - 2);
            }
        }
        return total;
    }
}
