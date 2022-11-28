package com.leetcode.binsearch;

public final class SortInRotatedArray {
    private SortInRotatedArray() {
    }

    public static int search(int[] nums, int target) {
        if (nums.length < 2 || nums[0] <= nums[nums.length - 1]) {
            return search(nums, target, 0, nums.length - 1);
        }
        int peakIndex = peakIndex(nums);
        int index = search(nums, target, 0, peakIndex - 1);
        if (index == -1) {
            return search(nums, target, peakIndex, nums.length - 1);
        }
        return index;
    }

    static int peakIndex(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return mid;
            }
            if (nums[mid] >= nums[i]) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
            if (nums[i] < nums[j]) {
                return i;
            }
        }
        if (nums[0] < nums[i]) {
            return i + 1;
        }
        return i;
    }

    private static int search(int[] nums, int target, int startIndex, int endIndex) {
        int i = startIndex;
        int j = endIndex;
        while (j >= i) {
            int mid = (i + j) / 2;
            if (nums[mid] == target) {
                return mid;
            } else {
                if (nums[mid] > target) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            }
        }
        return -1;
    }
}
