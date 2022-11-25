package com.leetcode.array;

public final class MonotonicArray {
    private MonotonicArray() {
    }

    public static boolean isMonotonic(int[] nums) {
        int i = 1;
        while (i < nums.length && nums[i] == nums[i - 1]) {
            i++;
        }
        if (i >= nums.length) {
            return true;
        }
        boolean isIncreasing = nums[i] > nums[i - 1];
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] != nums[j - 1] && nums[j] > nums[j - 1] != isIncreasing) {
                return false;
            }
        }
        return true;
    }
}
