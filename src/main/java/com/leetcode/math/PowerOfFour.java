package com.leetcode.math;

final class PowerOfFour {
    private PowerOfFour() {
    }

    static boolean isPowerOfFour(int n) {
        boolean isPositive = n > 0;
        boolean isPowerOfTwo = (n & (n - 1)) == 0;
        return isPositive && isPowerOfTwo && Integer.numberOfTrailingZeros(n) % 2 == 0;
    }
}
