package com.leetcode.array;

import java.util.Arrays;

final class SmallestRange2 {
    private SmallestRange2() {

    }

    static int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int bestScore = nums[nums.length - 1] - nums[0];
        int firstPlus = nums[0] + k;
        int lastMinus = nums[nums.length - 1] - k;
        for (int i = 0; i < nums.length - 1; i++) {
            int lastPlus = nums[i] + k;
            int firstMinus = nums[i + 1] - k;
            int score = Math.max(lastPlus, lastMinus) - Math.min(firstMinus, firstPlus);
            bestScore = Math.min(score, bestScore);
        }
        return bestScore;
    }
}
