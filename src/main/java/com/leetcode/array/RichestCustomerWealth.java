package com.leetcode.array;

public final class RichestCustomerWealth {
    private RichestCustomerWealth() {
    }

    public static int maximumWealth(int[][] accounts) {
        boolean seen = false;
        int best = 0;
        for (int[] acc : accounts) {
            int sum = 0;
            for (int i : acc) {
                sum += i;
            }
            if (!seen || sum > best) {
                seen = true;
                best = sum;
            }
        }
        if (seen) {
            return best;
        }
        return -1;
    }
}
