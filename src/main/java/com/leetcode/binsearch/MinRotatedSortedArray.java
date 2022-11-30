package com.leetcode.binsearch;

public final class MinRotatedSortedArray {
    private MinRotatedSortedArray() {

    }

    public static int findMin(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        if (nums.length == 1 || nums[i] < nums[j]) {
            return nums[i];
        }
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            if (nums[mid] >= nums[i]) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
            if (nums[i] < nums[j]) {
                return nums[i];
            }
        }
        if (nums[0] < nums[i]) {
            return nums[i + 1];
        }
        return nums[i];
    }
}
