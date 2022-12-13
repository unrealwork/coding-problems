package com.leetcode.array;

public final class MinimumAverageDifference {
    private MinimumAverageDifference() {
    }

    public static int minimumAverageDifference(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        long s = sum(nums);
        long left = nums[0];
        long right = s - nums[0];
        long bestRes = Math.abs(left - right / (nums.length - 1));
        int minIndex = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            left += nums[i];
            right -= nums[i];
            int b = i + 1;
            int d = nums.length - 1 - i;
            long curAbsDiff = Math.abs((left * d - right * b) / ((long) b * d));
            if (curAbsDiff < bestRes) {
                bestRes = curAbsDiff;
                minIndex = i;
            }
        }
        if (s / nums.length < bestRes) {
            return nums.length - 1;
        }
        return minIndex;
    }

    private static long sum(int[] nums) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
