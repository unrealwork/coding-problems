package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Permutations2 {
    private Permutations2() {
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> permutations = new ArrayList<>();
        int startIndex = 0;
        nextPermutation(Arrays.copyOf(nums, nums.length), startIndex, permutations);
        return permutations;
    }


    private static void nextPermutation(int[] nums, int i, List<List<Integer>> permutations) {
        if (i < nums.length) {
            int movedIndex = i;

            nextPermutation(nums, i + 1, permutations);
            for (int j = i - 1; j >= 0 && nums[j] < nums[movedIndex]; j--) {
                swapArr(nums, movedIndex, j);
                if (nums[movedIndex] != nums[j]) {
                    nextPermutation(nums, i + 1, permutations);
                }
                movedIndex = j;
            }
            int startJ = movedIndex;
            for (int j = startJ; j <= i; j++) {
                swapArr(nums, movedIndex, j);
                movedIndex = j;
            }
        } else {
            permutations.add(asList(nums));
        }
    }


    private static List<Integer> asList(int[] arr) {
        List<Integer> res = new ArrayList<>(arr.length);
        for (int n : arr) {
            res.add(n);
        }
        return res;
    }

    private static void swapArr(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
