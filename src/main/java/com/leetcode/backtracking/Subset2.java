package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Subset2 {
    private Subset2() {
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        Arrays.sort(nums);
        generatePowerSet(nums, 0, new ArrayList<>(), list);
        return list;
    }

    private static void generatePowerSet(int[] nums, int start, List<Integer> list, List<List<Integer>> lists) {
        for (int i = start; i < nums.length; i++) {
            if (i == start || nums[i - 1] != nums[i]) {
                int el = nums[i];
                List<Integer> next = new ArrayList<>(list);
                next.add(el);
                lists.add(next);
                generatePowerSet(nums, i + 1, next, lists);
            }
        }
    }
}
