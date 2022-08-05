package com.leetcode.backtracking;

import java.util.Arrays;

final class CombinationSumIV {

    private static final int MEMO_SIZE = 1001;

    private CombinationSumIV() {
    }

    static int combinationSum4(int[] nums, int target) {
        int[] memo = new int[MEMO_SIZE];
        Arrays.fill(memo, -1);
        return combinationSum4Rec(0, target, nums, memo);
    }

    private static int combinationSum4Rec(int curSum, int target, int[] nums, int[] memo) {
        if (curSum == target) {
            return 1;
        } else {
            if (curSum > target) {
                return 0;
            }
            if (memo[curSum] == -1) {
                memo[curSum] = 0;
                for (int n : nums) {
                    memo[curSum] += combinationSum4Rec(curSum + n, target, nums, memo);
                }
            }
            return memo[curSum];
        }
    }
}
