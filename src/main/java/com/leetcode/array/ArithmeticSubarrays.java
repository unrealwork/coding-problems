package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ArithmeticSubarrays {
    private ArithmeticSubarrays() {
    }

    public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>(l.length);
        for (int i = 0; i < l.length; i++) {
            res.add(isArithmetic(nums, l[i], r[i]));
        }
        return res;
    }

    private static boolean isArithmetic(int[] nums, int l, int r) {
        int len = r - l + 1;
        int[] arr = new int[len];
        System.arraycopy(nums, l, arr, 0, len);
        Arrays.sort(arr);
        int d = arr[1] - arr[0];
        for (int i = 2; i < len; i++) {
            if (arr[i] - arr[i - 1] != d) {
                return false;
            }
        }
        return true;
    }
}
