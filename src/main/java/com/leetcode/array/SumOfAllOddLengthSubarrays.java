package com.leetcode.array;

public final class SumOfAllOddLengthSubarrays {
    private SumOfAllOddLengthSubarrays() {
    }

    public static int sumOddLengthSubarrays(int[] arr) {
        int[] allSum = new int[arr.length];
        int[] oddSum = new int[arr.length];
        allSum[0] = arr[0];
        oddSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            allSum[i] = allSum[i - 1] + allSum[i - 1] + arr[i] * (i + 1);
            if (i > 1) {
                allSum[i] -= allSum[i - 2];
            }
            int prevEven = allSum[i - 1] - oddSum[i - 1];
            oddSum[i] = oddSum[i - 1] + prevEven;
            if (i > 1) {
                int prevPrevEven = allSum[i - 2] - oddSum[i - 2];
                oddSum[i] -= prevPrevEven;
            }
            int newSubsequenceCount = i / 2 + 1;
            oddSum[i] += newSubsequenceCount * arr[i];
        }
        return oddSum[arr.length - 1];
    }
}
