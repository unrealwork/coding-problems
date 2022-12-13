package com.leetcode.dp;

public final class SubarrayProductLessThan {
    private SubarrayProductLessThan() {
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int maxProduct = 1;
        int count = 0;
        while (j < nums.length) {
            maxProduct *= nums[j];
            while (i <= j && maxProduct >= k) {
                maxProduct /= nums[i];
                i++;
            }
            count += (j - i + 1);
            j++;
        }
        return count;
    }
}
