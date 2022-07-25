package com.leetcode.binsearch;

final class FindFirstAndLastPositions {
    private FindFirstAndLastPositions() {

    }

    public static int[] searchRange(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int midIndex = i + (j - i) / 2;
            if (nums[midIndex] == target) {
                return new int[] {
                        findBound(nums, i, midIndex, true, target),
                        findBound(nums, midIndex, j, false, target)
                };
            } else {
                if (nums[midIndex] < target) {
                    i = midIndex + 1;
                } else {
                    j = midIndex - 1;
                }
            }
        }
        return new int[] {-1, -1};
    }

    private static int findBound(int[] nums, int left, int right, boolean isLower, int target) {
        int i = left;
        int j = right;
        while (i != j) {
            int midIndex = i + (j - i) / 2;
            if (midIndex == i) {
                boolean isFirst = isLower && nums[i] == target
                        || !isLower && nums[j] != target;
                if (isFirst) {
                    return i;
                }
                return j;
            }
            boolean isTarget = nums[midIndex] == target;
            boolean isRightSide = isLower && isTarget || !isTarget && !isLower;
            if (isRightSide) {
                j = midIndex;
            } else {
                i = midIndex;
            }
        }
        return i;
    }
}
