package com.leetcode.array;

final class FindDuplicateNumber {
    private FindDuplicateNumber() {
    }

    public static int findDuplicate(int[] nums) {
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    res = nums[i];
                    break;
                }
                swap(nums, nums[i], i);
            }
        }
        return res;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
