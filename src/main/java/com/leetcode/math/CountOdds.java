package com.leetcode.math;

final class CountOdds {
    private CountOdds() {

    }

    public static int countOdds(int low, int high) {
        if (isOdd(high) || isOdd(low)) {
            return (high - low) / 2 + 1;
        }
        return (high - low) / 2;
    }

    private static boolean isOdd(int num) {
        return num % 2 != 0;
    }
}
