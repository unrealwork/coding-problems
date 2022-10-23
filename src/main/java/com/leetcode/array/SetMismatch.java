package com.leetcode.array;

public final class SetMismatch {
    private SetMismatch() {

    }

    public static int[] findErrorNums(int[] nums) {
        int[] order = new int[nums.length];
        int duplicated = 0;
        for (int num : nums) {
            int index = num - 1;
            if (num == order[index]) {
                duplicated = num;
            }
            order[index] = num;
        }
        for (int i = 0; i < order.length; i++) {
            if (order[i] == 0) {
                return new int[] {duplicated, i + 1};
            }
        }
        throw new IllegalStateException();
    }
}
