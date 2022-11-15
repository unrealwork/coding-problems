package com.leetcode.math;

public final class SubtractProductSumDigits {
    private SubtractProductSumDigits() {

    }

    public static int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        char[] symbols = Integer.toString(n).toCharArray();
        for (char symbol : symbols) {
            int d = symbol - '0';
            product *= d;
            sum += d;
        }
        return product - sum;
    }
}
