package com.leetcode.math;

public class CountOdds {
    private CountOdds() {
        
    }

    public static int countOdds(int low, int high) {
        return (high - low) / 2 + (isOdd(high) || isOdd(low) ? 1 : 0);
    }

    private static boolean isOdd(int num) {
        return num % 2 != 0;
    }
}
