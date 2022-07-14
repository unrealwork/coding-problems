package com.leetcode.array;


final class IncreasingTripletSubsequence {
    private IncreasingTripletSubsequence() {
    }

    public static boolean increasingTriplet(int[] nums) {
        int smallest = Integer.MAX_VALUE;
        int biggestAfterSmallest = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= smallest) {
                smallest = n;
            } else {
                if (n <= biggestAfterSmallest) {
                    biggestAfterSmallest = n;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
