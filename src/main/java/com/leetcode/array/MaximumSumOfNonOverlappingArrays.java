package com.leetcode.array;

final class MaximumSumOfNonOverlappingArrays {
    private MaximumSumOfNonOverlappingArrays() {
    }

    static int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int[] p = prefixSum(nums);
        int best = Integer.MIN_VALUE;
        for (int firstStartIndex = 0; firstStartIndex <= nums.length - firstLen; firstStartIndex++) {
            int firstEndIndex = firstStartIndex + firstLen - 1;
            for (int secondStartIndex = 0; secondStartIndex <= nums.length - secondLen; secondStartIndex++) {
                int secondEndIndex = secondStartIndex + secondLen - 1;
                if (firstStartIndex > secondEndIndex || secondStartIndex > firstEndIndex) {
                    int curSum = subarraySum(p, firstStartIndex, firstLen)
                            + subarraySum(p, secondStartIndex, secondLen);
                    best = Math.max(curSum, best);
                }
            }
        }
        return best;
    }

    private static int subarraySum(int[] p, int startIndex, int len) {
        if (startIndex == 0) {
            return p[len - 1];
        }
        return p[startIndex + len - 1] - p[startIndex - 1];
    }

    private static int[] prefixSum(int[] nums) {
        int[] p = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            p[i] = sum;
        }
        return p;
    }
}
