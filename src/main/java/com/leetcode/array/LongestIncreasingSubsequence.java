package com.leetcode.array;

final class LongestIncreasingSubsequence {
    private LongestIncreasingSubsequence() {
    }

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            int subseqlen = 0;
            for (int j = 0; j < i; j++) {
                if (dp[j] > subseqlen && nums[j] < nums[i]) {
                    subseqlen = dp[j];
                }
            }
            dp[i] = subseqlen + 1;
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
